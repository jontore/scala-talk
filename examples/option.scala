//Shows complier warning if Some is not handled
def higherThanThreshold(t: Int, xs: List[Int]): Int = {
  val found = xs find (_ > t)
  found match {
    case Some(f) => f
    case None => 0
  }
}
