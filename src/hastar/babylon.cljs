(ns hastar.babylon)

;; UTILITY
;; =======
(defn vec3 [x y z]
  (js/BABYLON.Vector3. x y z))

(defn color
  ([r g b]
   (js/BABYLON.Color3. r g b))
  ([r g b a]
   (js/BABYLON.Color4. r g b a)))

(defn texture [path scene]
  (js/BABYLON.Texture. path scene))



;; LIGHTS
;; ======
(defn directional-light [name [x y z] scene]
  (js/BABYLON.DirectionalLight. name
                                (vec3 x y z)
                                scene))

(defn point-light [name [x y z] scene]
  (js/BABYLON.PointLight. name
                          (vec3 x y z)
                          scene))


;; CAMERAS
;; =======
(defn camera [name [x y z] scene]
  (js/BABYLON.UniversalCamera. "camera"
                               (vec3 x y z)
                               scene))


;; MATERIALS
;; =========
(defn std-material [name scene]
  (js/BABYLON.StandardMaterial. name scene))
