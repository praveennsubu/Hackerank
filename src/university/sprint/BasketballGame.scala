package university.sprint

/**
 * @author Praveen
 */
object BasketballGame {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);
    val n = sc.nextInt();
    val score = new Array[Int](n);
    for (score_i <- 0 to n - 1) {
      score(score_i) = sc.nextInt();
    }

    var highest = score(0)
    var lowest = score(0)

    val highCount = score.count { x =>
      val temp = highest
      if (x > highest) {
       highest = x
       //println("high " + x)
      }
      x > temp
    }

    val lowCount = score.count { x =>
      val temp = lowest
      if (x < lowest) {
        //println("low " + x)
        lowest = x
      } 
      x < temp
    }

    println(highCount + " " + lowCount)
  }
}