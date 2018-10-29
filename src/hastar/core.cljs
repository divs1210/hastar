(ns hastar.core
  (:require [hastar.babylon :as B]))

(defn ^:export init [canvas scene]
  (def scene scene)
  (let [camera (B/camera "camera" scene [0 2 -5]) 
        light0 (B/directional-light "omni" scene [-2 -5 2])
        light1 (B/point-light "point" scene [-2 -5 2])
        ground (B/ground "ground" scene 20 20 1)
        crate (B/box "crate" scene 2)]
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
    (set! (.-checkCollisions crate) true)))
