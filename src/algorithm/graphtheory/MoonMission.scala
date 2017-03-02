package algorithm.graphtheory

import scala.io.StdIn.readLine
import scala.annotation.tailrec

/**<b>Problem</b>
 * Determine the disjointed sets from the given list of graph edges and find 
 * the count of number of ways the vertices of the graphs can be combined.
 * 
 * See <a href="https://www.hackerrank.com/challenges/journey-to-the-moon">here</a>
 * 
 * 
 * Using <a href="https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/">Disjoint Set Union Find</a> algorithm
 * and <a href="https://en.wikipedia.org/wiki/Disjoint-set_data_structure">Wikipedia</a>
 *
 * Used a <a href="http://www.ida.liu.se/opendsa/OpenDSA/Books/Everything/html/UnionFind.html">Weighted Union-Find</a> 
 * algorithm for reducing time complexity
 *
 *
 * @author praveen
 */
object MoonMission {
  def main(args: Array[String]): Unit = {
    val Array(noOfAstronauts, testCases) = readLine().split(" ").map(_.toInt)
    val astronauts = Array.tabulate(noOfAstronauts)(_ + 0)
    val ranks = Array.fill(noOfAstronauts)(0) //rank attributes for the nodes in a graph
    val inputs = Array.fill(testCases) { readLine().split(" ").map(_.toInt) }

    inputs.foreach { x =>
      //setting the value of the index x(0) with the value of x(1)
      //to denote their association
      val (first, second) = (x(0), x(1))

      union(first, second)
      
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
          updateAstronautRoots(firstRoot, secondRoot)
        } else if (ranks(first) > ranks(second)) {
          updateAstronautRoots(secondRoot, firstRoot)
        } else {
          updateAstronautRoots(secondRoot, firstRoot)
          ranks(second) = ranks(second) + 1
        }
      }
      
      //Implementing Path-Compression when finding root
      //Assigning the root of the graph as the parent of every node in the graph
      def findRoot(index: Int): Int = {
        val root = astronauts(index)
        if (root != index) {
          astronauts(index) = findRoot(root)
        }
        root
      }
      
      //Update the root of a graph with a new parent of the entire graph.
      //This is synonymous to pointing the root of a graph to the root of another graph,
      //(which now becomes the parent of the entire graph)
      def updateAstronautRoots(oldRoot: Int, newRoot: Int) = {
        astronauts.foreach{ x =>
          if(x == oldRoot) astronauts(x) = newRoot
        }
      }
    }
    
    //groups similar countries together, finds their counts and stores them in countryCounts
    val countryCounts = astronauts.groupBy(identity).mapValues(_.size).values.toList
    
    println(getPermissibleCount(countryCounts))
  }

  def getPermissibleCount(countryCounts: List[Int]): BigInt = {
    //(len1 + len2 +... lenN)^2 - (len1^2 + len2^2 + ... lenN^2)/2
    val sumOfCounts = BigInt(countryCounts.sum)
    val sumSquared = sumOfCounts * sumOfCounts
    val sumOfSquares = BigInt(countryCounts.map(x => x * x).sum)

    (sumSquared - sumOfSquares) / 2
  }
}