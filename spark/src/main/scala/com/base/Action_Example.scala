package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Demo16Action")
    val sc = new SparkContext(conf)

    val linesRDD: RDD[String] = sc.textFile("data/data/datas/students.txt")

    /**
     * 转换算子：将一个RDD转换成另一个RDD, 转换算子是懒执行，需要一个action算子来触发执行，不触发不执行
     * 操作算子：触发任务执行，一个action算子会触发一次任务执行, 同时每一个ation算子都会触发前面的代码执行
     */
    println("map之前")
    val studnetRDD: RDD[(String, String, Int, String, String)] = linesRDD
      .map(_.split(","))
      .map {
        case Array(id: String, name: String, age: String, gender: String, clazz: String) =>
          println("=======map============")
          (id, name, age.toInt, gender, clazz)
      }
    println("map之后")

    studnetRDD.foreach(println)
    println("=" * 100)
    studnetRDD.foreach(println)

    /**
     * action算子，action算子的返回值不是一个rdd, 每一个action算子都会触发一个job执行
     * foreach:循环RDD
     * saveAsTextFile:保持数据
     * count：统计行数
     * collect:将rdd转换成集合
     * take：取top
     * reduce:全局聚合
     * sum:求和，rdd必须可以求和
     */

    //保持数据
    studnetRDD.saveAsTextFile("data/temp")

    //统计RDD行数
    val count: Long = studnetRDD.count()

    println(count)

    /**
     * 将rdd转换成数组时，当处理的数据量很大时，会导致内存溢出
     */
    val studentArr: Array[(String, String, Int, String, String)] = studnetRDD.collect()

    //取top
    val top: Array[(String, String, Int, String, String)] = studnetRDD.take(100)

    //下面这两种写法结果一样
    val stuRDD: RDD[Int] = studnetRDD.map(s => 1)
    val reduce: Int = stuRDD.reduce((x, y) => x + y)
    val sum: Double = stuRDD.sum()
    println(reduce)
    println(sum)
  }
}
