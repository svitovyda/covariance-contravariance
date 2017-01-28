package com.svitovyda.education

object TestHierarchy {
  trait Drawable

  trait Shape extends Drawable

  class Circle(r: Int = 1) extends Shape

  case class FilledCircle(r: Int = 1, color: Int = 0) extends Circle(r)

  case class Square(w: Double = 1) extends Shape
}
