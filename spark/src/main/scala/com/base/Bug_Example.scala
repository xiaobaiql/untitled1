package com.base
/**
 * 下面的代码跑不出结果，一方面是转换算子是懒执行的，且只有当对RDD调用操作算子时，才会执行 。
 * 另一方面主要是因为集群下，变量只会以副本形式交给executor，而不会将变量的值变化传回driver，
 * 要想把值变化传会driver，需要定义一个可读写的共享变量，spark提供了两种共享变量，boardcast（广播变量）和accumulator（累加器变量）
 * 可以用两种形式的代码来实现上述需求，第一种是利用累加器或者广播变量，第二种是间接的方式，将所需数据抽取出来，然后再累加
 */
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Bug_Example {
  def main(args: Array[String]): Unit = {
    /**
    //spark所需配置
    val conf = new SparkConf()
    conf.setAppName("problem1")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //用于接收所有学生分数
    var allStuScore: Double = 0
    //读取所需数据
    val idAndScore: RDD[(String, Double)] = sc.textFile("data/data/datas/score.txt")
      //过滤脏数据
      .filter(line => line.split(",").length == 3)
      //获取学号，成绩
      .map {
        line =>
          val id: String = line.split(",").head
          val score: Double = line.split(",").last.toDouble
          allStuScore = allStuScore.+(score)
          println("-----------------temp-------------------")
          (id, score)
      }

    //计算每个学生的总分
    val value1: RDD[(String, Double)] = idAndScore.reduceByKey((x: Double, y: Double) => x + y)
    value1.cache()
    println(allStuScore)

    //计算年级平均分
    val numPerson: Double = value1.map { case (_, score: Double) => score }.count()
    val avgScore: Double = allStuScore / numPerson
    println(avgScore)

    //取出总分高于年纪平均分
    value1.filter { case (_, score: Double) => score > avgScore }.foreach(println)
    */
    //spark所需配置
    val conf = new SparkConf()
    conf.setAppName("problem1")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //用于接收所有学生分数
    var allStuScore: Double = 0
    //读取所需数据
    val idAndScore: RDD[(String, Double)] = sc.textFile("data/data/datas/score.txt")
      //过滤脏数据
      .filter(line => line.split(",").length == 3)
      //获取学号，成绩
      .map {
        line =>
          val id: String = line.split(",").head
          val score: Double = line.split(",").last.toDouble
          allStuScore = allStuScore.+(score)
          println("-----------------temp-------------------")
          (id, score)
      }

    //计算每个学生的总分
    val value1: RDD[(String, Double)] = idAndScore.reduceByKey((x: Double, y: Double) => x + y)
    value1.cache()
    println(allStuScore)

    /**
     * 计算年级平均分
     */
    //计算年级总分
    val allScore: Double = value1.map { case (_, score: Double) => score }.sum()
    //计算年纪总人数
    val numPerson: Double = value1.map { case (_, score: Double) => score }.count()
    val avgScore: Double = allScore / numPerson
    println(avgScore)

    //取出总分高于年纪平均分
    value1.filter { case (_, score: Double) => score > avgScore }.foreach(println)
  }
}
