(ns hastar.babylon)

;; UTILITY
;; =======
(defn vec3 [x y z]
  (js/BABYLON.Vector3. x y z))

(defn color [x y z]
  (js/BABYLON.Color3. x y z))


;; LIGHTS
;; ======
(defn directional-light [name scene [x y z]]
  (js/BABYLON.DirectionalLight. name
                                (vec3 x y z)
                                scene))

(defn point-light [name scene [x y z]]
  (js/BABYLON.PointLight. name
                          (vec3 x y z)
                          scene))


;; CAMERAS
;; =======
(defn camera [name scene [x y z]]
  (js/BABYLON.UniversalCamera. "camera"
                               (vec3 x y z)
                               scene))


;; SHAPES
;; ======
(defn ground [name scene width depth subdivs]
  (js/BABYLON.Mesh.CreateGround name
                                width
                                depth
                                subdivs
                                scene))


(defn box [name scene size]
  (js/BABYLON.Mesh.CreateBox name
                             size
                             scene))


;; MATERIALS
;; =========
(defn std-material [name scene]
  (js/BABYLON.StandardMaterial. name scene))


;; TEXTURES
;; ========
(defn texture [path scene]
  (js/BABYLON.Texture. path scene))
