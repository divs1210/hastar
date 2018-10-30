(ns hastar.babylon)

(defn upcase-first [[c & chars]]
  (apply str (cons (Character/toUpperCase c)
                   chars)))

(defn shape-method [shape]
  (->> shape
       name
       upcase-first
       (str "js/BABYLON.MeshBuilder.Create")
       symbol))

(defmacro shape [shape name props scene]
  `(~(shape-method shape) ~name (~'clj->js ~props) ~scene))
