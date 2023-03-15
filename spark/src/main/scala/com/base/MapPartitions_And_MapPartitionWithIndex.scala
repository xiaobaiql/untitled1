package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MapPartitions_And_MapPartitionWithIndex {
  def main(args: Array[String]): Unit = {
    // spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    val linesRDD: RDD[String] = sc.textFile("data/data/datas/words")
    println(linesRDD.getNumPartitions)
    /**
     * mapPartitions:一次处理一个分区的数据， 将一个分区的数据一个一个传递给后面的函数
     * 迭代器中是一个分区的数据
     * 函数的返回值也需要是一个迭代器
     */
    val mapRDD: RDD[String] = linesRDD.mapPartitions((iter: Iterator[String]) => {
      //在函数类对一个分区的数据进行处理
      val words: Iterator[String] = iter.flatMap(line => line.split(","))
      words
    })
    mapRDD.foreach(println)

    /**
     * mapPartitionsWithIndex:对指定分区编号的分区进行处理
     */
    linesRDD
      .mapPartitionsWithIndex {
        case (index: Int, iter: Iterator[String]) =>
          println(s"当前处理的分区编号：$index")
          Thread.sleep(50000)
          iter
      }
      .foreach(println)
  }
}
