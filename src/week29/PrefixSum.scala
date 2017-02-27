package week29

object PrefixSum {
  def main(args: Array[String]): Unit = {
    val firstArr = Array(1,2,3,4)
    val prefix = getPrefixSumArr(firstArr)
    prefix.foreach(println)
  }
  
  def getPrefixSumArr(arr : Array[Int]) = {
    val prefixSumArry = new Array[Int](arr.length)
    for(index <- arr.indices) {
      if(index == 0) prefixSumArry(index) = arr(index)
      else prefixSumArry(index) = prefixSumArry(index - 1) + arr(index)
    }
    prefixSumArry
  }
}