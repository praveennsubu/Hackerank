package datastructures.stack

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

/**
 * See <a href="https://www.hackerrank.com/challenges/maximum-element">Here</a> for problem statement
 * 
 * @author Praveen S
 * 
 * */
object MaximumElement {
  def main(args : Array[String]) : Unit = {
    val noOfInputs = readLine().toInt
    val stack = ListBuffer.empty[Int]
    val maxElem = ListBuffer(0)
    val inputs = Array.fill(noOfInputs){ readLine().split(" ").map(_.toInt) }
    
    inputs.foreach{ x =>
      val option = x(0)
      
      val res = option match {
        case 1 => stack.+=:(x(1))//add elem to top of stack
                  if(x(1) >= maxElem.head) maxElem.+=:(x(1))
        case 2 => val poped = stack(0)
                  stack.remove(0)
                  if(maxElem.head == poped) maxElem.remove(0)
        case 3 => println(maxElem.head)
      }
    }
  }
}