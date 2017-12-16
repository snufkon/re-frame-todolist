(ns re-frame-todolist.views
  (:require [re-frame.core :as re-frame]
            [re-frame-todolist.subs :as subs]))

(defn todo-item
  [todo]
  [:li (:title todo)])

(defn todo-list
  []
  (let [todos @(re-frame/subscribe [::subs/todos])]
    [:ul
     (for [todo todos]
       ^{:key (:id todo)}
       [todo-item todo])]))
