Test project reproducing issues with JUnit parallel test runner
====

How to use it
----

To produce the issue, build the project with Maven and run the test class `TestCalculator`.

Context
----

`Calculator` is a class designed to run some fake calculation using `ForkJoinTask`. They can be `RecursiveTask` or `CountedCompleter`.<br>
These are representative of real code in our projects, though the tasks are not as dummy as in this project.

JUnit is configured to use a fixed limited number of workers to run tests in parallel. Here configured to `2`, as it is enough to highlight the issues.<br>
The idea being limited this number is that tests are using a lot of resources and the parallelism is configured with respect to what the machine running tests can support. For example, a simple Database for tests can accept a limited number of connections.

Observed issue
----

The observed issue is that, when activating parallel tests, JUnit uses `ForkJoinPoolHierarchicalTestExecutorService`. However, our tests are also using `ForkJoinPool`s and `ForkJoinTask`s. The orchestration of the test awaits for the completion of those tasks before moving on in the tests.<br>
But the issue is that `ForkJoinTask` and `ForkJoinWorkerThread` are capable of detecting the use of the FJP framework and react to it. As JUnit tasks and the project tasks are in different ForkJoinPools, they cannot help each other. This only results in more tests being started by already running and **incomplete** tests.

An alternative implementation of the executor service, as shown in [this PR](https://github.com/junit-team/junit5/pull/2805), using a standard Thread Executor, would not show similar issues, at the expense of not ideally orchestrating multiple executions.
