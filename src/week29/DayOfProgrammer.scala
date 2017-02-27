package week29

import scala.io.StdIn.readInt

object Solution1 {
    def main(args: Array[String]): Unit = {
        val y = readInt()
        
        println(if(y > 1918) gregorianDayOfP(y) else julianDayOfP(y)) 
    }
    
    def gregorianDayOfP(y : Int) : String = {
      if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
        "12.09."+y //is leap
      else
        "13.09."+y //not leap
    }
    
    def julianDayOfP(y : Int) : String = {
      if(y == 1918)
        "26.09."+y
      else if(y%4 == 0)
        "12.09."+y //leap
      else
        "13.09."+y //not leap
    }
}