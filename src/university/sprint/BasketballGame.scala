package university.sprint

import scala.io.StdIn.readLine

/**
 * <b>Problem </b>
 * Maria plays 'n' games of college basketball in a season. Because she wants to go pro, she tracks her
 * points scored per game sequentially in an array defined as score = [s0,s1,...sN-1] . After each game i,
 * she checks to see if score s(i) breaks her record for most or least points scored so far during that season.
 *
 * Given Maria's array of 'scores' for a season of n games, find and print the number of times she breaks her 
 * record for most and least points scored during the season.
 *
 * <b>Input Format</b>
 *
 * The first line contains an integer denoting 'n' (the number of games).
 * The second line contains 'n' space-separated integers describing the respective values of s0,s1,...sN-1.
 *
 * <b>Output Format</b>
 *
 * Print two space-seperated integers describing the respective numbers of times her best (highest) score 
 * increased and her worst (lowest) score decreased.
 *
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