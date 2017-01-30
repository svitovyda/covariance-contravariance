package com.svitovyda.education

object TestHierarchy {
  trait Drawable {
    def draw(): Unit = println(toString)
  }

  trait Shape extends Drawable

  class Circle(val r: Int = 1) extends Shape
  object Circle {
    def apply(r: Int = 1): Circle = new Circle(r)
    def unapply(arg: Circle): Option[Int] = Some(arg.r)
  }

  case class FilledCircle(override val r: Int = 1, color: Int = 0) extends Circle(r)

  case class Square(w: Double = 1) extends Shape
}
