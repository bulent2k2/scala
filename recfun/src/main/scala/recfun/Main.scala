package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || c == r || r == 1) 1 else pascal(c, r - 1) + pascal(c - 1, r - 1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def countChar(chars: List[Char], ch: Char): Int = {
        if (chars.isEmpty) 0 else {
          if (chars.head == ch) 1 + countChar(chars.tail, ch) else countChar(chars.tail, ch)
        }
      }

      val open = '('
      val close = ')'
      val reverse = chars.reverse
      val numOpen = countChar(chars, open)
      val numClose = countChar(chars, close)
      if (chars.isEmpty || (numOpen == 0 && numClose == 0)) true else if (numOpen != numClose ) false else {
        val firstOpen = chars.indexOf(open)
        val lastClose = chars.size - reverse.indexOf(close) - 1
        if ( firstOpen > chars.indexOf(close) || reverse.indexOf(close) > reverse.indexOf(open)) false else {
          balance(chars.drop(firstOpen + 1).dropRight(lastClose + 1))
        }
      }
  }
  
  /**
   * Exercise 3
   */

  def countChange(money: Int, coins2: List[Int]): Int = {

    def howMany(acc: Int, coins: List[Int], target: Int): Int = {
      if (coins.head == 0 || target <= 0) acc else {
        // 			println(List(acc,coins,target))
        val max_coin = coins.head
        if (target < max_coin) howMany(acc, coins.tail, target) else
        if (target == max_coin)	howMany(acc + 1, coins, target - max_coin) + howMany(acc, coins.tail, target) else {
          howMany(acc, coins, target - max_coin) + howMany(acc, coins.tail, target)
        }
      }
    }

    val sorted = (coins2++List(0)).toSet.toList.sorted.reverse
    howMany(0, sorted, money)
  }
}
