package challenge

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

/**
 * @author Praveen
 */
object SpareArray {
  def main(args: Array[String]) : Unit = {
      val numberOfStrings = readLine().toInt  
      val strings = List.fill(numberOfStrings){readLine()}
      val numberOfQueries = readLine().toInt
      val queries = List.fill(numberOfQueries){readLine()}
      
      queries.foreach { x => 
                        println(strings.count(_.equals(x))) }
  }
}