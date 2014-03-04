object ListDemo {

  def print[T](xs: List[T]): String = {
    xs match {
      case List() => ""
      case x :: xs1 => x + "---" + print(xs1)
    }
  }

  //Shows complier error if Some is not handled
  def higherThanThreshold(t: Int, xs: List[Int]): Int = {
    val found = xs find (_ > t)
    found match {
      case Some(f) => f
      case None => 0
    }
  }

  def multiplyList(xs: List[Int]): Int = {
    (1 /: xs) (_ * _)
  }

}



//Should print formatted list
println(ListDemo.print(List.range(1, 5)))

// Should print 10
println(ListDemo.higherThanThreshold(5, List(2, 1, 2, 4, 10, 5, 7, 2)))

//Should
println(ListDemo.multiplyList(List.range(1, 5)))
