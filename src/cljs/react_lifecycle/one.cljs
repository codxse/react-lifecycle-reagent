(ns react-lifecycle.one
  (:require [reagent.core :as r]))

(enable-console-print!)

(def global-state (r/atom "hello"))

(defn LifeCycle [x y z]
  (let [this-state (atom 0)]
    (r/create-class
      {:display-name "LifeCycle"
       :component-did-mount
         (fn [this]
           (println "Component did mount"))
       :component-will-mount
         (fn [this]
           (println "Component will mount"))
       :get-initial-state
         (fn [this]
           (println "Initial state"))
       :component-will-receive-props
         (fn [this new-argv]
           (println "Component will receive props"))
       :should-component-update
         (fn [this old-argv new-argv]
           (println "Should component update"))
       :component-will-update
         (fn [this new-argv]
           (println "Will update"))
       :component-did-update
         (fn [this old-argv]
           (println "Did update"))
       :component-will-unmount
         (fn [this]
           (println "Will unmount"))
       :reagent-render
         (let [seconds-elapsed (r/atom 0)]
           (js/setInterval #(swap! seconds-elapsed inc) 1000)
           (fn [a b c]
             [:div
              [:div (str "Parameters: " a " " b " " c)]
              [:div (str "Rendered count: " @this-state)]
              [:div (str "Seconds: " @seconds-elapsed)]
              [:div (str @global-state)]]))})))


