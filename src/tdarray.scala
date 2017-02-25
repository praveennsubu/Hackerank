

import scala.collection.mutable.ListBuffer
 /* @author Praveen
 */
object tdarray {
  
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var arr = Array.ofDim[Int](6,6);
        for(arr_i <- 0 to 6-1) {
           for(arr_j <- 0 to 6-1){
              arr(arr_i)(arr_j) = sc.nextInt();
           }
        }
        
        var max = Int.MinValue
        
        for {
          row <- 0 to 3
          col <- 0 to 3
        } {
          val currentSum = getHourglassElems(arr, row, col).reduceLeft(_ + _)
          if (currentSum > max) 
            max = currentSum
        }
        
        print(max)
    }
    
    def getHourglassElems(arr : Array[Array[Int]], row: Int, col : Int) : ListBuffer[Int] = {
      val hourGlass = ListBuffer.empty[Int]
        for{
            i <- (row to row+2)
            j <- (col to col+2)
        } {
          hourGlass.append(arr(i)(j))
        } 
         //println("")
        hourGlass.remove(3)
        hourGlass.remove(4) //the 5th element becomes 4th after removing the 3rd 
        hourGlass
        
    } 
    
}