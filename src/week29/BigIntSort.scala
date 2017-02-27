package week29

object Solution {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var unsorted = new Array[String](n);
    for (unsorted_i <- 0 to n - 1) {
      unsorted(unsorted_i) = sc.next();
    }
    
    unsorted.map(BigInt(_)).sorted.foreach(println)
  }

}