package datastructures.stack

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

/**
 * <h3>Balanced Brackets</h3>
 *
 * See <a href="https://www.hackerrank.com/challenges/balanced-brackets">here</a> for problem statement
 */
object BalancedBrackets {
  def main(args: Array[String]): Unit = {
    val noOfInputs = readLine().toInt
    val inputs = Array.fill(noOfInputs) { readLine() }
    val closingBraces = Array(')', ']', '}')
    val openingBraces = Array('(', '[', '{')

    inputs.foreach { input => //iterating through inputs
      println(isBalancedBracket(input))
    }
    
    def isBalancedBracket(input: String) : String = {
      val stack = ListBuffer.empty[Char]
      for(char <- input) {
        if(openingBraces.contains(char)) char +=: stack
        else {
          if(stack.isEmpty) return "NO"
          val head = stack.head
          stack.remove(0)
          if(closingBraces.indexOf(char) != openingBraces.indexOf(head)) return "NO"
        }
      }
      if(stack.isEmpty) "YES" else "NO"
    }

  }
}