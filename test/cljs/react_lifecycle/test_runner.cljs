(ns react-lifecycle.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [react-lifecycle.core-test]
   [react-lifecycle.common-test]))

(enable-console-print!)

(doo-tests 'react-lifecycle.core-test
           'react-lifecycle.common-test)
