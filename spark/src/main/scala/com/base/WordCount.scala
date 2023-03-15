package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    /**
     * 创建spark环境
     */
    //spark的环境配置对象
    val sparkConf = new SparkConf()

    //设置spark任务的名称
    sparkConf.setAppName("wordCount")

    //设置spark任务的运行模式，本地模式
    sparkConf.setMaster("local")

    //创建spark上下文对象，sc是spark写代码的入口
    val sparkContext = new SparkContext(sparkConf)

    //读取文件
    val value: RDD[String] = sparkContext.textFile("data/data/datas/words.txt")

    //拆分字段
    val value1: RDD[String] = value.flatMap((i: String) => i.split(","))

    //统计每个单词的个数
    value1.map((_,1)).reduceByKey(_+_).foreach(println)
  }
}
