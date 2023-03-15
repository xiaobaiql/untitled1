package com.base

import org.apache.spark.{SparkConf, SparkContext}

object SortBy_Function {
  def main(args: Array[String]): Unit = {
    // spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    sc
      .textFile("data/data/datas/score.txt")
      .filter(i=>i.split(",").length>=3)
      .map(i=>(i.split(",").head,i.split(",")(2)))
      .sortBy((kv:(String,String))=> kv._2.toInt,ascending = false)
      .foreach(println)
  }
}
