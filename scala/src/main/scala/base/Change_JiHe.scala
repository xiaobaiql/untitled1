package base

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * 可变集合
 * ListBuffer:List有的方法ListBuffer都有，只是ListBuffer是可以改变的
 */
object Change_JiHe {
  def main(args: Array[String]): Unit = {
    val listBuffer = new ListBuffer[String]
    listBuffer.append("hadoop")
    listBuffer.append("spark")
    listBuffer.append("flink")
    listBuffer.foreach(print(_))

    listBuffer.+= ("qq")
    listBuffer += "ww"

    //删除指定元素
    listBuffer.remove(1)
    listBuffer -= "ww"

    //插入元素
    listBuffer.insert(2,"qq")
    //批量插入数据，有两个加号
    listBuffer ++= List("1","2","3")

    //更新元素
    listBuffer.update(2,"pp")

    /**
     * 可变Set
     */
    val hashSet = new mutable.HashSet[Int]()

    //增加元素
    hashSet += 1
    hashSet += 2
    hashSet += 3
    println(hashSet)

    //删除元素
    hashSet -= 1
    println(hashSet)


  }
}
