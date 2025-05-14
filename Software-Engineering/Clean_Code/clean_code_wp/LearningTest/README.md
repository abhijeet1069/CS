# Learning Test

This project was initially started for learning test lesson from clean code.
Initially, the goal was to learn

- SnakeYAML : for reading YAML configuration from file and converting it to POJO
- LogBack : for logging

But as we progressed, we learned following too:

- JUnit5 : How to test for errors in tester.TestYAMLConfigServiceUnHappyCase
 to combine test cases in a test suite and execute at once.

- Law of Demeter : com.satyam.learningTest.YAMLConfigService was layer over POJO, so that clients don't
exactly manipulate the POJO, and get into the internals of data-structures

- LogUtil : This LogUtil is a beautiful case of logging. Just see the latest logs in logs/app.log
is storing who logged, when it logged and what it logged in a short and precise manner.

- TDD : I saw the benefits of TDD:
	- I can refactor fearlessly and know that my code didn't break
	- I can change my libraries and get an early feedback that code won't break in production
	- TDD is great motivator, you start with a failing test, so now you have an objective to anyhow fix this
	- TDD also allows the developer to focus on the right objective. Developers mostly approach their code 
      from bottom to top, and then forget the main objective of project.
      For ex : We started with the objective to log what our application is doing under the hood. But
      messed up with the internals of APIs of Logback or Log4J etc. And we start searching for
      magic framework and end up shipping less features.