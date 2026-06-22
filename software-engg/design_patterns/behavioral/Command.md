# Command Pattern

The Command Pattern turns a request into a standalone object, which contains all the information about the request — 
like what action to do, who should do it, and when.

Use the Command Pattern when you want to treat actions as objects — to parameterize, queue, log, or undo them, while decoupling sender and receiver.

In the example com.designPatterns.behavior.command, 
RemoteControl has Command. Its sets and tells when to execute the command.
