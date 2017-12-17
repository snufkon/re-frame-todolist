(ns re-frame-todolist.db)

(def default-db
  {:todos {1 {:id 1 :title "豚肉を買ってくる" :completed true}
           2 {:id 2 :title "たまねぎを買ってくる" :completed true}
           3 {:id 3 :title "にんじんを買ってくる" :completed false}
           4 {:id 4 :title "じゃがいもを買ってくる" :completed false}
           5 {:id 5 :title "カレーを作る" :completed false}}})
