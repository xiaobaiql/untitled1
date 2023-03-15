package com.base

import org.apache.spark.{SparkConf, SparkContext}

object Filter_Function {
  def main(args: Array[String]): Unit = {
    //spark的环境配置
    val conf = new SparkConf()
    conf.setAppName("filter函数").setMaster("local")
    val sparkContext = new SparkContext(conf)

    //读取文件并处理
    sparkContext
      .textFile("data/data/datas/students.txt")
      .filter(i => "男".equals(i.split(",")(3)))
      .foreach(println)
  }
}
