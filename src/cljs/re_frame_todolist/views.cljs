(ns re-frame-todolist.views
  (:require [re-frame.core :as re-frame]
            [re-frame-todolist.subs :as subs]
            ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div "Hello from " @name]))
