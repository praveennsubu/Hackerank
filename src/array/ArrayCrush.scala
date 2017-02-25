package array

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap

/**
 * @author Praveen
 */
object ArrayCrush {
  def main(args: Array[String]): Unit = {
    val inputs = readLine().split(" ").map(_.toInt)
    val outList = Array.fill(inputs(0))(0)
    
    val outMap = new HashMap[Int, Int]
    val queries = List.fill(inputs(1)) { readLine().split(" ").map(_.toInt).toList }

    queries.foreach { x => 
     (x(0)-1 to x(1)-1).foreach{
       y => outList.update(y, outList(y) + x(2))
     }
    }
    
    //println(outList.toList)
    println(outList.max)
  }
}