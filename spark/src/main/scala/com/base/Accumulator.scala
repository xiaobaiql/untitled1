package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Accumulator {
  def main(args: Array[String]): Unit = {
    //spark所需配置
    val conf = new SparkConf()
    conf.setAppName("累加器")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //定义累加器对象
    val allScore: LongAccumulator = sc.longAccumulator("计算所有学生的总分")

    //读取文件
    val scoreRDD: RDD[String] = sc.textFile("data/data/datas/score.txt").filter(_.split(",").length == 3)

    scoreRDD.map {
      line => {
        val score: Long = line.split(",").last.toLong
        allScore.add(score)
        (1, score)
      }
    }.reduceByKey(_ + _).foreach(println)

    val value: Long = allScore.value
    println(value)
  }
}
