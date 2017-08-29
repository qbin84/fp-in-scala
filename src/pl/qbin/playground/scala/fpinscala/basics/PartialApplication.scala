package pl.qbin.playground.scala.fpinscala.basics


object PartialApplication extends App {

  val f1 = partialAppl(42, (a: Int, b: String) => "F1 a: " + a + ", b: " + b)
  val f2 = partialAppl(84, (a: Int, b: String) => "F2 a: " + a + ", b: " + b)
  println(f1("str"))
  println(f2("str2"))

  val c1 = curry((a: Int, b: String) => "C1 a: " + a + ", b: " + b)(42)("str")
  val c2 = curry((a: Int, b: String) => "C1 a: " + a + ", b: " + b)(84)
  println(c1)
  println(c2("str2"))

  val uc1 = uncurry(curry((a: Int, b: String) => "C1 a: " + a + ", b: " + b))
  println(uc1(42, "str1"))

  val comp1 = compose((b: String) => "f(" + b + ")", (a: Int) => "g(" + a + ")")
  println(comp1(42))

  val comp2 = ((b: String) => "f(" + b + ")") compose ((a: Int) => "g(" + a + ")")
  val comp3 = (((a: Int) => "g(" + a + ")")) andThen ((b: String) => "f(" + b + ")")
  println(comp2(42))
  println(comp3(42))


  def partialAppl[A,B,C](a: A, f: (A,B) => C): B => C = {
    b: B => f(a, b)
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    a: A => ((b: B) => f(a, b))
  }

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    a: A => f(g(a))
  }
}
