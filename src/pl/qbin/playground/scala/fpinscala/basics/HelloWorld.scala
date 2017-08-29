package pl.qbin.playground.scala.fpinscala.basics

object HelloWorld extends App {

  override def main(args: Array[String]): Unit = {
    val msg = "Hello world from main %d"
    println(msg.format(42))
    println(hof(factorial, 5))
    println(hof(fibb, 10))
  }

  def factorial(number: Int): Int = {
    @annotation.tailrec
    def go(num: Int, acc: Int): Int =
      if (num <= 0) acc
      else go(num - 1, num * acc)

    go(number, 1)
  }

  def fibb(numPos: Int) : Int = {
    @annotation.tailrec
    def go(numPos: Int, prev: Int, curr: Int): Int =
      if (numPos == 0) prev;
      else go(numPos - 1, curr, prev + curr);

    go(numPos, 0, 1);
  }

  def hof(f: Int => Int, number: Int) =
    f(number)

  println("Hello world");
}
