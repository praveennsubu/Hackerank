package university.sprint

import scala.io.StdIn.readLine

/**
 * @author Praveen
 */
object BasketballGame {
  def main(args: Array[String]): Unit = {
    val numberOfGames = readLine().toInt
    val score = List { readLine().split(" ").map(_.toInt) }.flatten

    val max = score.tail.scanLeft(score.head) {
      (acc, num) =>
        acc max num
    }.toSet.filter { x => x != score.head }

    val min = score.tail.scanLeft(score.head) {
      (acc, num) =>
        acc min num
    }.toSet.filter { x => x != score.head }

    println(max.size + " " + min.size)

    /*var highest = score(0)
    var lowest = score(0)*/

    /* val high = score(0).tail.scanLeft(score.head){
        (acc, num) => acc max num
    }*/

    /* val highCount = score.count { x =>
      val temp = highest
      if (x > highest) {
       highest = x
      }
      x > temp
    }
    */

    /* val lowCount = score.count { x =>
      val temp = lowest
      if (x < lowest) {
        lowest = x
      } 
      x < temp
    }

    println(highCount + " " + lowCount)*/
  }
}