package array

import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

/**
 * <b>Problem</b>
 *
 * You are given a list of size 'N', initialized with zeroes. You have to perform 'M' operations on the list
 * and output the maximum of final values of all the 'N' elements in the list.
 * For every operation, you are given three integers a,b  and k and you have to add value k to all the
 * elements ranging from index  to (both inclusive).
 *
 * <b>Input Format</b>
 *
 * First line will contain two integers N and M separated by a single space.
 * Next M lines will contain three integers a, b and k separated by a single space.
 * Numbers in list are numbered from 1 to N
 *
 * <b>Output Format</b>
 *
 * A single line containing maximum value in the updated list.
 *
 * <b>Sample Input</b>
 *
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 *
 * <b>Sample Output</b>
 *
 * 200
 *
 * @see <a href="https://www.hackerrank.com/challenges/crush">Hackkerrank.com</a>
 *
 * @author Praveen
 *
 */
object ArrayCrush {
  def main(args: Array[String]): Unit = {
    val Array(arrayLen, numberOfQueries) = readLine().split(" ").map(_.toInt)
    val outList = Array.ofDim[Long](arrayLen + 1)
    val queries = Array.fill(numberOfQueries) {readLine().split(" ").map(_.toInt)}
    
    queries.foreach { query =>
      val startIndex = query(0) - 1
      val endIndex = query(1)
      val sum = query(2)
      
      outList(startIndex) = outList(startIndex) + sum
      outList(endIndex) = outList(endIndex) - sum
    }
   
    //all valid ways to calculate Kadane's algorithm for max sub array
    //val result = outList.tail.scanLeft(outList.head)((acc, x) => (acc+x).max(x)).max 
    /*val result = outList.foldLeft(0L -> 0L) {
      case ((maxUpToHere , maxSoFar), n) =>
        val maxEndingHere = 0L.max(maxUpToHere + n)
        maxEndingHere -> (maxEndingHere max maxSoFar)
    }._2*/
    
    val result = outList.scanLeft(0L)((acc, n) => (acc + n) max 0).max
    
    println(result)
  }
}