(ns hastar.babylon)

;; Utils
;; =====
(defn- upcase-first [[c & chars]]
  (apply str (cons (Character/toUpperCase c)
                   chars)))

(defn- shape-method [shape]
  (->> shape
       name
       upcase-first
       (str "js/BABYLON.MeshBuilder.Create")
       symbol))


;; API
;; ===
(defmacro shape
  "Create 3D shapes like :sphere, :box, :ground, :plane, :cylinder.
  Compiles to BABYLON.MeshBulider.Create<Shape>"
  [shape name props scene]
  `(~(shape-method shape) ~name (~'clj->js ~props) ~scene))

(defmacro click-handler!
  "Register a click-handler: a fn that will receive PointerEvents."
  [[e] & body]
  `(set! js/clickHandler
         (fn [~e]
           ~@body)))
