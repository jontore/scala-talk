object ListDemo {

  def print[T](xs: List[T]): String = {
    xs match {
      case List() => ""
      case x :: xs1 => x + "---" + print(xs1)
    }
  }

  def multiplyList(xs: List[Int]): Int = {
    // (1 /: xs) (_ * _)
    xs.foldRight(1) (_ * _)
  }

}



//Should print formatted list
println(ListDemo.print(List.range(1, 5)))

// Should print 10
println(ListDemo.higherThanThreshold(5, List(2, 1, 2, 4, 10, 5, 7, 2)))

//Should
println(ListDemo.multiplyList(List.range(1, 5)))

val a = (123, 'a')

val (aInt, aString) = a
