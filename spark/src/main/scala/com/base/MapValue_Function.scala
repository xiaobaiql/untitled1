package com.base

import org.apache.spark.{SparkConf, SparkContext}

object MapValue_Function {
  def main(args: Array[String]): Unit = {
    // spark环境
    val conf = new SparkConf()
    conf.setAppName("ReduceByKey函数")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    sc
      .textFile("data/data/datas/score.txt")
      //拆分字段
      .map(_.split(","))
      //过滤数据
      .filter(_.length==3)
      //取id,成绩
      .map{
        case Array(sid: String, _: String, sco: String) =>
          (sid, sco.toInt)
      }
      //根据id分组聚合
      .reduceByKey(_+_)
      //按照总成绩排序
      .sortBy{
        case Tuple2(sid:String,sco:Int)=> - sco
      }
      //调用mapValues函数
      .mapValues(scp=>scp/10)
      .foreach(println)
  }
}
