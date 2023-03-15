package base

import scala.collection.mutable

/**
 * map：kv格式的集合
 */
object Map_Key_And_Value {
  def main(args: Array[String]): Unit = {
    //定义一个Map集合
    var map = Map((1, "小白"), (2, "百晓生"), (3, "白小纯"))

    //可以通过key获取value
    println(map(1))

    //如果key不存在返回默认值
    println(map.getOrElse(4, "nobody"))

    /**
     * 将每个人的ID变成以100开头
     * map集合的map方法，函数的参数是一个二元组,
     * 返回一个新的map
     */
    map.map((kv:(Int,String))=>{
      val i = kv._1+1000
      (i,kv._2)
    }).get(1001).foreach(println)

    //获取所有的key和value
    println(map.keys)
    println(map.values)

    /**
     * 可变map集合
     */
    val hashMap = mutable.HashMap[Int,String]()

    hashMap += 1->"1_x"
    hashMap += 2->"2_x"

    println(hashMap)

    //key相同，数据会覆盖
    hashMap += 2->"2_Y"
    println(hashMap)

    hashMap.remove(2)
    hashMap -= 1
    println(hashMap)
  }
}
