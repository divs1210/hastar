# hastar

WIP game in ClojureScript using [BabylonJS](https://www.babylonjs.com/)

## Why

Clojure is designed to be a "hosted" language. From the [official website](https://clojure.org/):

> Clojure is designed to be a hosted language, sharing the JVM type system, GC, threads etc.

ClojureScript is Clojure hosted on JS VMs.

I personally prefer ClojureScript over JS - it is a pleasure to use, and comes with great tooling and libraries.
When I want to do something - such as write a SPA, or draw charts, or communicate over websockets,
or write state-machines, or even 2D games, there is generally a high-level idiomatic ClojureScript library
available for me to use.

Game Engines are some of the most mutation-heavy systems around, and writing games - especially
3D ones - in functional languages is still a very arcane topic. Sadly, there also appears to be
no stable, high-level, well-maintained Clojure/Script library for this purpose.

I will talk about my journey of writing a 3D game in Clojure:
- what choices I made
- what problems I faced
- how I solved / worked around them
- what the game is like right now
- where I am going with it

I will also demo the game and talk about my experiences, likes/dislikes, and the overall suitability
of Clojure for a project like this, and how it performed under the stress of working with an inherently
alien, mutable world.

Mostly, I want to find out whether writing "serious" 3D games in Clojure is possible and practical,
and what are the tradeoffs it entails.

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload.

## Build

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 
