package com.base

import org.apache.spark.{SparkConf, SparkContext}

object Samle_Function {
  def main(args: Array[String]): Unit = {
    //spark的环境配置
    val conf = new SparkConf()
    conf.setAppName("Sample函数").setMaster("local")
    val sparkContext = new SparkContext(conf)
    //读取文件
    sparkContext
      .textFile("data/data/datas/students.txt")
      //Sample函数对数据按比例进行抽样，但不是绝对意义上的按比例抽样
      //参数withReplacement要指定，为true是放回抽样，后面的0.1是抽样比例
      .sample(withReplacement = false, 0.01)
      .foreach(println)
  }
}
