(ns react-lifecycle.core
  (:require [reagent.core :as reagent :refer [atom]]
            [react-lifecycle.one :as one]))


(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut!"}))

(defn greeting []
  [:h1 (:text @app-state)])

(defn render []
  (reagent/render [one/LifeCycle] (js/document.getElementById "app")))
