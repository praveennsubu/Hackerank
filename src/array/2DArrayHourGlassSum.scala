

package array

import scala.collection.mutable.ListBuffer
/* @author Praveen
 */
object tdarray {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val arr = Array.ofDim[Int](6, 6);
    for (arr_i <- 0 to 6 - 1) {
      for (arr_j <- 0 to 6 - 1) {
        arr(arr_i)(arr_j) = sc.nextInt();
      }
    }

    val results = new ListBuffer[Int]

    for (i <- 0 to 3; j <- 0 to 3) {
      val firstRow = arr(i) slice (j, j + 3)
      val secondRow = arr(i + 1) (j + 1)
      val thirdRow = arr(i + 2) slice (j, j + 3)

      val ans = firstRow.sum + thirdRow.sum + secondRow

      results.append(ans)
    }

    println(results.max)
  }

}