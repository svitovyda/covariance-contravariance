package com.svitovyda.education

import com.svitovyda.education.TestHierarchy._

object ExplanationClasses {
  object Demo1 {
    class MyClassCo[T <: Shape]

    //new MyClassCo[Drawable] error
    new MyClassCo[Shape]
    new MyClassCo[Circle]
    new MyClassCo[FilledCircle]
    new MyClassCo[Null]
    new MyClassCo[Nothing]

    class MyClassContra[T >: Shape]

    //new MyClassContra[Circle] // error
    new MyClassContra[Shape]
    new MyClassContra[Drawable]
    new MyClassContra[AnyRef]
    new MyClassContra[Any]
  }

  object Demo2 {
    class MyClassCo[+T]

    val a: MyClassCo[Shape] = new MyClassCo[Square]
    val b: MyClassCo[Shape] = new MyClassCo[Null]

    class MyClassContra[-T]

    val c: MyClassContra[Shape] = new MyClassContra[Drawable]
    val d: MyClassContra[Shape] = new MyClassContra[AnyRef]
  }

  object Demo3 {
    // with [-T] - Error:
    // contravariant type T occurs in covariant position in type ()T of method read
    class Producer[T] {
      /**
        * we can assign result of read to val/var of type -T, like in
        * `val a: Drawable = new Producer[Square].read()`
        * but we can't define something like `def read(): -T` :)
        * this is why we can define `class Producer[T] {`
        * @return T
        */
      def read(): T = ??? // co-variant position
    }

    def fCo(src: Producer[Drawable]): Unit = {
      val a: Drawable = src.read()
    }
    // fCo(new Producer[Circle]) // possible if `class Producer[+T]`
    // fCo(new Producer[Square])
    // fCo(new Producer[FilledCircle])


    // with [+T] - Error:
    // covariant type T occurs in contravariant position in type T of value x
    class Consumer[T] {
      /**
        * almost the same: we can call `write(x: Drawable)` with parameter of type `Circle`
        * but we can't define here write(x: +T) :)
        * so we can define Consumer as class Consumer[-T]
        * @param x: T
        */
      def write(x: T): Unit = ??? // contra-variant position
    }

    val s: Shape = Square()
    def fContra(sink: Consumer[Shape], a: Shape): Unit = sink.write(a)

    //fContra(new Consumer[Drawable], s) // possible if `class Consumer[-T]`

    //can be only non-variant
    class Pipe[T] {
      // both read/write can be here
      def f(x: T): T = ???
    }

    def fNon(pipe: Pipe[Shape]): Unit = {
      val l = List(new Circle(), Square(), FilledCircle())
      val r = l map pipe.f
    }
  }

  /**
    * getters and setters are most used examples of producer/consumer
    */
  object Demo4 {
    class MyClassVar[T](var value: T) // ok
    class MyClassVarCo[+T](var value: T) // Error:
      // covariant type T occurs in contravariant position in type T of value value_=
    class MyClassVarContra[-T](var value: T) // Error:
      // contravariant type T occurs in covariant position in type => T of method value

    class MyClassVal[T](val value: T) // ok
    class MyClassValCo[+T](val value: T) // ok
    class MyClassValContra[-T](val value: T) // Error:
      // contravariant type T occurs in covariant position in type => T of value value
  }

}
