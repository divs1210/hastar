(ns hastar.core
  (:require [hastar.babylon :as B])
  (:require-macros [hastar.babylon :refer [shape]]))

(defn ^:export init [canvas scene]
  (def canvas canvas)
  (def scene scene)

  (set! (.-fogMode scene) js/BABYLON.Scene.FOGMODE_EXP2)

  ;; camera
  ;; ======
  (def camera (B/camera "camera" [0 2 -5] scene))
  (set! (.-target camera) (B/vec3 0 1.5 0))
  (.attachControl camera canvas false)

  (def torch (B/point-light "torch" [0 2 -5] scene))
  (set! (.-intensity torch) 0.5)
  (set! (.-parent torch) camera)

  ;; ground
  ;; ======
  (def ground
    (shape :ground
           "ground"
           {:width 200
            :height 200
            :subdivisions 20}
           scene))

  (def grass-material
    (B/std-material "grass" scene))

  (set! (-> grass-material .-diffuseTexture)
        (B/texture "./textures/grass.png" scene))
  (set! (.-material ground) grass-material)

  ;; crate
  ;; =====
  (def crate
    (shape :box "crate" {:size 2} scene))

  (set! (-> crate .-position .-y) 1)

  (def crate-material
    (B/std-material "crate" scene))

  (set! (-> crate-material .-diffuseTexture)
        (B/texture "./textures/crate.png" scene))
  (set! (-> crate-material .-bumpTexture)
        (B/texture "./textures/crate-bump.png" scene))
  (set! (-> crate-material .-diffuseTexture .-hasAlpha) true)
  (set! (-> crate-material .-bumpTexture .-hasAlpha) true)
  (set! (.-material crate) crate-material)

  ;; gravity
  ;; =======
  (set! (.-gravity scene) (B/vec3 0 -0.9 0))
  (set! (.-applyGravity camera) true)

  ;; collisions
  ;; ==========
  (set! (.-collisionsEnabled scene) true)
  (set! (.-checkCollisions camera) true)
  (set! (.-ellipsoid camera) (B/vec3 1 1 1))
  (set! (.-checkCollisions ground) true)
  (set! (.-checkCollisions crate) true)

  ;; mouse clicks
  ;; ============
  (set! js/clickHandler
        (fn [e]
          (js/console.log e))))
