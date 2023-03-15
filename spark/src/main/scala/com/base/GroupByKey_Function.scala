package com.base

import org.apache.spark.{SparkConf, SparkContext}

object GroupByKey_Function {
  def main(args: Array[String]): Unit = {
    //spark环境
    val conf = new SparkConf()
    conf.setAppName("group函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件，并计算
    sc
      .textFile("data/data/datas/students.txt")
      .map(i=>{
        val strings = i.split(",")
        (strings(4),strings(1))
      })
      .groupByKey()
      .foreach(println)
  }
}
