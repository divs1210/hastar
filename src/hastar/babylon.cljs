(ns hastar.babylon)

;; UTILITY
;; =======
(defn vec3 [x y z]
  (js/BABYLON.Vector3. x y z))

(defn color [x y z]
  (js/BABYLON.Color3. x y z))


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


;; TEXTURES
;; ========
(defn texture [path scene]
  (js/BABYLON.Texture. path scene))
