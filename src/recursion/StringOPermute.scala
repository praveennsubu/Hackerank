package recursion

import scala.annotation.tailrec

/**
 * @author Praveen
 */
object StringOPermute {
  
  def main(args:Array[String]) : Unit = {
     /*val testCases = scala.io.StdIn.readInt
     val inputs = new Array[String](testCases)
     
     for(n <- 0 to testCases-1) {
       inputs(n) = scala.io.StdIn.readLine
     }
     
     for(input <- inputs) {
       stringConcat(input, 0)
     }*/
    
    stringConcat("az", 0)
  }
  
  @tailrec
  def stringConcat(input: String, a : Int) : Unit = {
    if(a+2 <= input.length) {
        print(input(a+1)); print(input(a));
        return stringConcat(input, a+2)
    } else {
      println("")
    }
  }
  
}