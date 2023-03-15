package base

/**
 * 在scala中可以使用java的集合,使用方法与Java中的几乎一摸一样
 * 增强for循环本质上是使用迭代器进行循环
 * scala和java使用的不是同一种迭代器，所有java的集合在scala语言中不能使用增强for循环进行遍历
 * for (i:Int <- list) {
 *      函数体
 * }
 */
import java.util
object For_Circle {
  def main(args: Array[String]): Unit = {
    val arrays = new util.ArrayList[String]()
    arrays.add("hadoop")
    arrays.add("flink")
    arrays.add("spark")

    var i=0
    while(i<arrays.size()){
      println(arrays.get(i))
      i+=1
    }
  }
}
