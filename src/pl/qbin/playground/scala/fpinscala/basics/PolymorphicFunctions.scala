package pl.qbin.playground.scala.fpinscala.basics


object PolymorphicFunctions extends App {

  println("First string (expected 2): " + findFirst(Array("other", "other2", "searched", "other3"), str => "searched".equals(str)));
  println("First int (expected 3): " + findFirst(Array(42, 43, 44, 45), int => 45.equals(int)));
  println("First double (expected -1): " + findFirst(Array(42.0, 43.1, 44.2, 45.3), dbl => 0.1.equals(dbl)));

  println("Is string array ordered (expected true): " + isSorted(Array("str1", "str2", "str3", "str4"),
    (str1: String, str2: String) => str1.compareTo(str2) < 0))
  println("Is string array ordered (expected false): " + isSorted(Array("str1", "str2", "str4", "str3"),
    (str1: String, str2: String) => str1.compareTo(str2) < 0))
  println("Is int array ordered (expected true): " + isSorted(Array(1, 2, 3, 4),
    (i1: Int, i2: Int) => i1 < i2))
  println("Is int array ordered (expected false): " + isSorted(Array(1, 2, 4, 3),
    (i1: Int, i2: Int) => i1 < i2))


  def findFirst[A](array: Array[A], f: A => Boolean): Int = {
    def loop(i: Int): Int = {
      if (i >= array.length) -1
      else if (f(array(i))) i
      else loop(i + 1)
    }

    loop(0)
  }

  def isSorted[A](array: Array[A], isOrdered: (A, A) => Boolean): Boolean = {
    def loop(i: Int): Boolean = {
      if (array.length < 2) true
      else if ((i + 1) >= array.length) true
      else if (!isOrdered(array(i), array(i+1))) false
      else loop(i + 1)
    }

    loop(0)
  }
}
