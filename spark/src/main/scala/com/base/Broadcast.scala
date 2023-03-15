package com.base

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import scala.io.Source

object Broadcast {
  def main(args: Array[String]): Unit = {
    //spark所需配置
    val conf = new SparkConf()
    conf.setAppName("BroadCast")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取学生表，成绩表
    val scoreRDD: RDD[String] = sc.textFile("data/data/datas/score.txt")
    val studentList: List[(String, String)] = Source.fromFile("data/data/datas/students.txt").getLines().toList.map {
      line =>
        val id: String = line.split(",").head
        val scores: String = line.split(",").tail.mkString(",")
        (id, scores)
    }

    //定义一个广播对象，将学生表包装起来，发送给Executor
    val bd: Broadcast[List[(String, String)]] = sc.broadcast(studentList)

    //遍历成绩表
    scoreRDD.map {
      line => {
        val id: String = line.split(",").head
        val sco: String = line.split(",").tail.mkString(",")
        val stuMessage: Map[String, String] = bd.value.toMap
        val message: String = stuMessage.get(id).mkString(",")
        (id, s"$sco,$message")
      }
    }.foreach(println)
  }
}
