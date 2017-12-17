(ns re-frame-todolist.events
  (:require [re-frame.core :as re-frame]
            [re-frame-todolist.db :as db]))

(defn- allocate-next-id
  [todos]
  (-> todos
      keys
      last
      ((fnil inc 0))))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::add-todo
 (fn [db [event title]]
   (let [id (allocate-next-id (:todos db))
         new-todo {:id id :title title :completed false}]
     (update db :todos #(assoc % id new-todo)))))

(re-frame/reg-event-db
 ::toggle
 (fn [db [event id]]
   (update-in db [:todos id :completed] not)))

(re-frame/reg-event-db
 ::delete
 (fn [db [event id]]
   (update db :todos dissoc id)))
