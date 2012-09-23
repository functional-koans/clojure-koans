(def agent-example
  "Agents provide shared access to mutable state."
  (agent 10))

(meditations
  "Creating an Agent is as simple as assigning it a value"
  (= __ (instance? clojure.lang.Agent agent-example))

  "To get agent's value you dereference it"
  (= __ @agent-example)

  "To set a new value, you use send or send-all functions, but you can't just send anything.."
  (= __ (do
          (set-error-mode! agent-example :continue)
          (send agent-example 20)
          @agent-example))

  "Send takes a function and arguments and sends them to the agent. The send function,
   returns immediately, but the action is prccessed in a separate thread and it's the result,
   of that action that gets assigned to agent's state"
  (= __ (do
          (send agent-example + 2)
          @agent-example))

  "You can create validations for states that agent is allowed to take"
  (= __ (do
          (set-validator! agent-example #(even? %))
          (try
            (send agent-example + 1)
            (catch IllegalStateException e))
          (agent-error agent-example))))
