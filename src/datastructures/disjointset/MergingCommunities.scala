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
    val ranks = Array.fill(noOfPersons)(0) //rank attributes for the nodes in a graph
    val inputs = Array.fill(testCases) { readLine().split(" ")}
    val results = new ListBuffer[Int]
    
    inputs.foreach { x => 
      val query = x(0)
      
      if(query == "Q") {
         val person = persons(x(1).toInt - 1)
         results.append(persons.count(_ == person))
      } else {
        val (first, second) = (x(1).toInt - 1, x(2).toInt - 1)
        union(first,second)
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

        if (ranks(first) < ranks(second)) {
          updatePersonRoot(firstRoot, secondRoot).copyToArray(persons)
        } else if (ranks(first) > ranks(second)) {
          updatePersonRoot(secondRoot, firstRoot).copyToArray(persons)
        } else {
          updatePersonRoot(secondRoot, firstRoot).copyToArray(persons)
          ranks(second) = ranks(second) + 1
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
      //Uses Scala match to replace oldRoot value with the newRoot
      def updatePersonRoot(oldRoot: Int, newRoot: Int) = {
        persons.map[Int, Array[Int]] { case `oldRoot` => newRoot; case x => x }
      }
      
    }
    
    results.foreach(println)
  }
}