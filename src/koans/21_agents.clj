(meditations
 (let [agent-example (agent 10)]

   "Creating an Agent is as simple as assigning a value to it"
   (= __ (instance? clojure.lang.Agent agent-example))

   "To get agent's value you dereference it"
   (= __ @agent-example)

   "To change agent's value you can use 'send' function. Send takes as parameters, agent, action and arguments,
    it returns immediately but the action is prccessed in a separate thread and it's the result, of action,
    that gets assigned to agent's state"
   (= __ (do
           (send agent-example + 2)
           @agent-example))

   "You can't just send a value to agent it needs to be a function"
   (= __ (do
           (set-error-mode! agent-example :continue)
           (send agent-example 20)
           @agent-example))

   "You can create validations for states that agent is allowed to take"
   (= __ (do
           (set-validator! agent-example #(even? %))
           (try
             (send agent-example + 1)
             (catch IllegalStateException e))
           @agent-example))

   "It's a good idea to clean up any not finished agents after you are done"
   (shutdown-agents)))
