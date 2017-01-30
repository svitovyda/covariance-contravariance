### Motivation:

Wanted to understand deeply co-variance, contra-variance, non-variance.

This are usually things you read once and forgot in few weeks, while using explicitly
only co-variance. So I decided to write simple examples to have it as a quick reminder of 
different more abstract purposes of generic types (and also good way to keep in memory Scala 
type hierarchy - chains `Any -> AnyVar -> ... -> Nothing`, `Any -> AnyRef -> ... Null -> Nothing`)

Code is written during re-listening to lectures of course **"Scala for Java developers"** on **Udemy** 
(on Russian)

Nothing to run here, doesn't even compile.

### `TestHierarchy`
Contains simplest hierarchy of threads/classes so that examples with 
them don't look unreadable like those examples that use only
`Any -> AnyRef -> Null -> Nothing`

### `ExplanationClasses`
Contains Demo objects with different class definitions and usages of generic types

### `ExplanationFunctions`
_tba_
