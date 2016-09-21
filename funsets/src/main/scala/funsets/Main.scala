package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(!contains(singletonSet(1), 2))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val u1 = union(s1, s2)
  val i1 = intersect(u1,s1)
  val m1 = map(u1, x => x + 10)
  printSet(m1)
  println(List(contains(u1, 2), contains(u1, 1), !contains(u1, 0)))
  println(List(contains(i1, 1), !contains(i1, 2)))
  println(exists(u1, x => x < -10))
  println(List(contains(m1, 12), contains(m1, 11), !contains(m1, 1)))
}
