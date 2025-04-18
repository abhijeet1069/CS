# Strategy Pattern

The strategy suggests that you take an original class(context) that does something specific in a lot of different ways
and extract all of these algorithms into separate classes called strategies.
    The context isn't responsible for selecting an appropriate algorithm for the job. Instead the client passes the 
desired strategy to the context.