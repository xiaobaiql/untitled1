package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Join_Function {
  def main(args: Array[String]): Unit = {
    // spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件
    /**
     * 内关联
     */
    val studentMessage: RDD[(String, String)] = sc.parallelize(List(
      ("001", "张三"),
      ("002", "李四"),
      ("003", "王二"),
      ("005", "刘五")
    ))
    val scoreMessage: RDD[(String, Int)] = sc.parallelize(List(
      ("001", 60),
      ("002", 70),
      ("003", 89),
      ("004", 100)
    ))
    studentMessage
      .join(scoreMessage)
      .foreach(println)

    /**
     * 左关联
     */
    studentMessage.leftOuterJoin(scoreMessage).foreach(println)

    /**
     * 右关联
     */
    studentMessage.rightOuterJoin(scoreMessage).foreach(println)

    /**
     * 全关联
     */
    studentMessage.fullOuterJoin(scoreMessage).foreach(println)
  }
}
