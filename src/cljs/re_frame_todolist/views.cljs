(ns re-frame-todolist.views
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [re-frame-todolist.events :as events]
            [re-frame-todolist.subs :as subs]
            [clojure.string :as cstr]))

(defn todo-item
  [todo]
  [:li (:title todo)])

(defn todo-input
  []
  (let [val (reagent/atom "")]
    (fn []
      [:input {:type        "text"
               :value       @val
               :class       "new-todo"
               :placeholder "What needs to be done?"
               :on-change   #(reset! val (-> % .-target .-value))
               :on-key-down #(when (= (.-which %) 13)
                               (let [title (-> @val cstr/trim)]
                                 (when (seq title)
                                   (re-frame/dispatch [::events/add-todo title]))
                                 (reset! val "")))}])))

(defn todo-list
  []
  (let [todos @(re-frame/subscribe [::subs/todos])]
    [:div
     [todo-input]
     [:ul
      (for [todo todos]
        ^{:key (:id todo)}
        [todo-item todo])]]))
