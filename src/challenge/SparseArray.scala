package challenge

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

/**
 * Problem:
 * There are 'N' strings. Each string's length is no more than 20 characters.
 * There are also 'Q' queries. For each query, you are given a string, and you need
 * to find out how many times this string occurred previously.
 *
 * Input Format
 *
 * The first line contains 'N', the number of strings.
 * The next 'N' lines each contain a string.
 * The N+2nd line contains 'Q', the number of queries.
 * The following 'Q' lines each contain a query string.
 * 
 * Constraints
 * 
 * 1 <= N <= 1000
 * 1 <= Q <= 1000
 * 1 <= length of any string <= 20
 *
 *  @see <a href="https://www.hackerrank.com/challenges/sparse-arrays?h_r=internal-search">Hackkerrank.com</a>
 *
 * @author Praveen
 */
object SparseArray {
  def main(args: Array[String]): Unit = {
    val numberOfStrings = readLine().toInt
    val strings = List.fill(numberOfStrings) { readLine() }
    val numberOfQueries = readLine().toInt
    val queries = List.fill(numberOfQueries) { readLine() }

    queries.foreach { x =>
      println(strings.count(_.equals(x)))
    }
  }
}