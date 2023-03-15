package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object Map_Function {
  def main(args: Array[String]): Unit = {
    //创建Spark环境
    val sparkConf = new SparkConf()
    val conf = sparkConf.setAppName("map的使用").setMaster("local")
    val sparkContext = new SparkContext(conf)

    //读取文件
    val value: RDD[String] = sparkContext.textFile("data/基础信息.txt")

    value.map((i:String)=>i.split(",").mkString("    ")).saveAsTextFile("data/message.txt")
  }
}
