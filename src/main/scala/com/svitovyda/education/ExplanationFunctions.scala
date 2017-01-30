package com.svitovyda.education

import com.svitovyda.education.TestHierarchy._

class ExplanationFunctions {
  object Demo1 {

    /**
      * {{{
      *   trait Function1[-T1, +R] extends AnyRef { self =>
      *     def apply(v1: T1): R
      *     ...
      *   }
      * }}}
      *
      * T1 is, as argument of method - in contra-variant position
      * R is, as the result of method - in co-variant position
      *
      */


  }

  /**
    * Union types
    */
  object Demo2 {
    type ¬[A] = A => Nothing
    type ∨[T, U] = ¬[¬[T] with ¬[U]]

    type ¬¬[A] = ¬[¬[A]]
    type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }

    def size[T : (Int |∨| String)#λ](t : T): Int = t match {
      case i : Int => i
      case s : String => s.length
    }

    size(6) // 6
    size("abs") // 3
  }
}
