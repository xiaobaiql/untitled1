package com.base

import org.apache.spark.{SparkConf, SparkContext}

object Union_Function {
  def main(args: Array[String]): Unit = {
    //spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件
    val v1 = sc.textFile("data/data/datas/1.txt")
    val v2 = sc.textFile("data/data/datas/2.txt")
    v1
      .union(v2)
      .foreach(println)
  }
}
