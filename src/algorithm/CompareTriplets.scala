package algorithm

import scala.io.StdIn.readLine

/**
 * @see <a href="https://www.hackerrank.com/challenges/compare-the-triplets">Hackkerrank.com</a>
 * 
 * @author Praveen
 */
object CompareTriplets {
  def main(args: Array[String]) {    
    val alice = List{readLine().split(" ").map(_.toInt)}.flatten
    val bob = List{readLine().split(" ").map(_.toInt)}.flatten
    
    val result = alice zip bob filter { case (x, y) => x != y } partition { case (x, y) => x > y }
    println(result._1.length + " " + result._2.length)
  }
}