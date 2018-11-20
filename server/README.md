# 2D world simulator

Simple simulator to allow us to provide a playgrounds for testing of drone behaviour.

Let's come up with some basic http interface. Transport and everything else is a subject
to change without a notice.

```
/world/create - create a world with certain parameters
input: { :x :y } or { :prototype-id }
output: { :world-id }

/world/:world-id/state - return current state of the simulated world
output: { :world-state }

/world/:world-id/agent/spawn - create a new agent
output { :agent-id }

/world/:world-id/agent/:agent-id/state - current state of the agent
output { :x :y :speed-x :speed-y }

/world/:world-id/agent/:agent-id/control - update the behaviour of drone
input { :thrust-x :thrust-y }, thrust is in range [-1,1]

/world/:world-id/agent/:agent-id/task - current task for the dron
output { :x :y :task-id }

/world/:world-id/agent/:agent-id/task/:task-id/report - current task for the dron
input { :complete }
```
