---
layout: doc-page
title: "Dropped: Limit 22"
movedTo: https://docs.scala-lang.org/scala3/reference/dropped-features/limit22.html
---

The limits of 22 for the maximal number of parameters of function types and the
maximal number of fields in tuple types have been dropped.

* Functions can now have an arbitrary number of parameters. Functions beyond
  [`scala.Function22`](https://www.scala-lang.org/api/current/scala/Function22.html) are erased to a new trait [`scala.runtime.FunctionXXL`](https://dotty.epfl.ch/api/scala/runtime/FunctionXXL.html).

* Tuples can also have an arbitrary number of fields. Tuples beyond [`scala.Tuple22`](https://www.scala-lang.org/api/current/scala/Tuple22.html)
  are erased to a new class [`scala.runtime.TupleXXL`](https://dotty.epfl.ch/api/scala/runtime/TupleXXL.html) (which extends the trait [`scala.Product`](https://dotty.epfl.ch/api/scala/Product.html)). Furthermore, they support generic
  operation such as concatenation and indexing.

Both of these are implemented using arrays.
