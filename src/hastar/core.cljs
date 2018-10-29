(ns hastar.core
  (:require [hastar.babylon :as B])
  (:require-macros [hastar.babylon :refer [shape]]))

(defn ^:export init [canvas scene]
  (def canvas canvas)
  (def scene scene)

  (def camera
    (B/camera "camera" [0 2 -5] scene)) 

  (def light0
    (B/directional-light "omni" [-2 -5 2] scene))

  (def light1
    (B/point-light "point" [-2 -5 2] scene))

  (def ground
    (shape :ground "ground" {:width 20 :height 20} scene))

  (def crate
    (shape :box "crate" {:size 2} scene))

  ;; camera
  (set! (.-target camera) (B/vec3 0 1.5 0))
  (.attachControl camera canvas false)

  ;; crate
  (set! (.-material crate)
        (B/std-material "Mat" scene))
  (set! (-> crate .-material .-diffuseTexture)
        (B/texture "./textures/crate.png" scene))
  (set! (-> crate .-material .-diffuseTexture .-hasAlpha) true)
  (set! (-> crate .-position .-y) 1)

  ;; gravity
  (set! (.-gravity scene) (B/vec3 0 -0.9 0))
  (set! (.-applyGravity camera) true)

  ;; collisions
  (set! (.-collisionsEnabled scene) true)
  (set! (.-checkCollisions camera) true)
  (set! (.-ellipsoid camera) (B/vec3 1 1 1))
  (set! (.-checkCollisions ground) true)
  (set! (.-checkCollisions crate) true))
