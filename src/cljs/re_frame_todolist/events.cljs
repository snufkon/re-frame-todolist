(ns re-frame-todolist.events
  (:require [re-frame.core :as re-frame]
            [re-frame-todolist.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))
