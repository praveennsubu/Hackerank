package datastructures.disjointset

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

/**
 * @author Praveen
 */
object MergingCommunities {
  def main(args: Array[String]): Unit = {
    val Array(noOfPersons, testCases) = readLine().split(" ").map(_.toInt)
    val persons = Array.tabulate(noOfPersons)(_ + 0)
    val ranks = Array.fill(noOfPersons)(1) //rank attributes for the nodes in a graph
    val inputs = Array.fill(testCases) { readLine().split(" ") }

    inputs.foreach { x =>
      val query = x(0)

      if (query == "Q") {
        //val person = persons(x(1).toInt - 1)
        val person = x(1).toInt - 1
        val root = findRoot(person)
        println(ranks(root))
      } else {
        val (first, second) = (x(1).toInt - 1, x(2).toInt - 1)
        union(first, second)
      }

      //Union method to merge two subsets if they belong together.
      //Uses ranks to flatten out the graph.
      //All subsets have 0 rank first. For adding two nodes/graphs that have same rank,
      //arbitrarily add one to the other and increase the rank of the latter by 1.
      //For different ranks, add the graph with the smaller rank to root of the graph with 
      //the bigger rank
      def union(first: Int, second: Int) = {
        val firstRoot = findRoot(first)
        val secondRoot = findRoot(second)

        if (ranks(secondRoot) > ranks(firstRoot)) {
          persons(firstRoot) = secondRoot
          ranks(secondRoot) = ranks(secondRoot) + ranks(firstRoot)
        } else if (ranks(secondRoot) < ranks(firstRoot)) {
          persons(secondRoot) = firstRoot
          ranks(firstRoot) = ranks(secondRoot) + ranks(firstRoot)
        } else {
          persons(secondRoot) = firstRoot
          ranks(firstRoot) = ranks(secondRoot) + 1
        }

      }

      //Implementing Path-Compression when finding root
      //Assigning the root of the graph as the parent of every node in the graph
      def findRoot(index: Int): Int = {
        val root = persons(index)
        if (root != index) {
          persons(index) = findRoot(root)
        }
        root
      }

      //Update the root of a graph with a new parent of the entire graph.
      //This is synonymous to pointing the root of a graph to the root of another graph,
      //(which now becomes the parent of the entire graph)
      def updatePersonRoot(oldRoot: Int, newRoot: Int) {
        persons.foreach { x =>
          if (x == oldRoot) persons(x) = newRoot
        }
        //persons.map[Int, Array[Int]] { case `oldRoot` => newRoot; case x => x }
      }

    }
  }
}