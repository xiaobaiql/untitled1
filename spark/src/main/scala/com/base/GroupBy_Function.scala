package com.base

import org.apache.spark.{SparkConf, SparkContext}

object GroupBy_Function {
  def main(args: Array[String]): Unit = {
    //spark环境
    val conf = new SparkConf()
    conf.setAppName("group函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件
    sc
      .textFile("data/data/datas/students.txt")
      .groupBy(i=>i.split(",")(4))
      .foreach(println)
  }
}
