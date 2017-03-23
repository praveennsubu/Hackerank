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
      val stack = ListBuffer.empty[Char]
      val result = checkBalancedBracket(input, 0)
      if (result) println("YES")
      else println("NO")
    }

    def checkBalancedBracket(input: String, index: Int): Boolean = {
      val stack = ListBuffer.empty[Char]

      @tailrec
      def check(index: Int): Boolean = {
        if (index < input.length) {
          val char = input(index)
          if (closingBraces.contains(char) && isBalancedBracket(char)) { //if the current char is a closing brace
            stack.remove(0)
            check(index + 1)
          } else if (openingBraces.contains(char)) { //if opening brace, push them to stack
            char +=: stack
            check(index + 1)
          } else false //braces don't match
        } else if (index == input.length() && !stack.isEmpty) false //string finished, but stack not empty. not balanced
        else true //entire string read. no errors. braces match
      }
           
      def isBalancedBracket(closingBrace: Char): Boolean = {
        if (stack.length == 0) false
        else if (openingBraces.indexOf(stack.head) == closingBraces.indexOf(closingBrace)) //braces match
          true
        else false
      }

      return check(0)
    }

    def isBalancedBracket(closingBrace: Char): Boolean = {
      true
    }

  }
}