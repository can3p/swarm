# What would you do to control a swarm? Or to program it?

The idea is to write a simple server that can simulate 2d world
and allow to test different stategies for drone behavior.

For example:

* Come from point A to point B
* Form a shape
* Surround an object
* Follow moving object
* Avoid obstacles
* Work with noisy data

The task is two-fold. First, we need to build a basic
framework to simulate the world, program an assignment
and render it somewhere. In addition to that this framework
should supply drones with a bare minimum of information,
which can range from absolute coordinates to something
more fuzzy, like speed and distance and directions towards
other objects.

Second, we should program drones themselves. Drones should
be able to udnerstand an assignment and cooperate with other
drones if necessary. The idea is to minimize the amount
of data to the extend that algorithm can be applied to
real hardware.

World map can be something simple like plain area, or
can include passages, moving objects etc.
