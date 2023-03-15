package com.base

import org.apache.spark.{SparkConf, SparkContext}

object ReduceByKey_Function {
  def main(args: Array[String]): Unit = {
    //spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件，并计算
    sc
      .textFile("data/data/datas/score.txt")
      .filter(i=>i.split(",").length>=3)
      .map(i=>(i.split(",")(0).toInt,i.split(",")(2).toInt))
      .reduceByKey((x:Int,y:Int)=> x+y)
      .sortBy((kv:(Int,Int))=> -kv._2)
      .foreach(println)
  }
}
