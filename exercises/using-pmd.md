# Using PMD

Pick a Java project from Github (see the [instructions](../sujet.md) for suggestions). Run PMD on its source code using any ruleset. Describe below an issue found by PMD that you think should be solved (true positive) and include below the changes you would add to the source code. Describe below an issue found by PMD that is not worth solving (false positive). Explain why you would not solve this issue.

## Answer
By running PMD on the common collection of Appache, we found a false positive : more than one return in the method. In this case it is a false positive since the method is quite simple and breaking th eloop earlier actually improves the performance of the code. 

We also found a true positive in  classe StandAlone.java, whith a System.log.out() method invoked where a logger should be used. 