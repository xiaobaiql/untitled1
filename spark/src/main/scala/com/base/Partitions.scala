package com.base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Partitions {
  def main(args: Array[String]): Unit = {
    /**
     * 1、创建spark环境
     */
    //spark环境配置对象
    val conf = new SparkConf()

    //设置spark任务的名称
    conf.setAppName("Demo1WordCount")

    //设置spark运行模式，local:本地运行
    conf.setMaster("local")

    //创建spark上下文对象，sc是spark写代码的入口
    val sc = new SparkContext(conf)
    /**
     * 2、读取文件
     * spark读取文件底层的代码和MapReduce是一样的
     * 所以切片规则一样
     * spark是一个切片对应一个分区
     * RDD：弹性的分布式数据集，现阶段可以当初list集合使用
     */
    //如果是在集群运行，就是读取hdfs的文件
    val linesRDD: RDD[String] = sc.textFile("data/data/datas/words.txt",4)
    println(s"linesRDD的分区数：${linesRDD.getNumPartitions}")

    /**
     * 3、将单词展开
     */
    val wordsRDD: RDD[String] = linesRDD.flatMap(line => line.split(","))

    /**
     * 4、按照单词分组
     */
    val kvRDD: RDD[(String, Iterable[String])] = wordsRDD.groupBy(word => word)

    /**
     * 5、统计单词的数量
     */

    val wordCount: RDD[String] = kvRDD.map {
      case (word: String, iter: Iterable[String]) =>
        val count: Int = iter.size
        s"$word\t$count"
    }

    /**
     * 6、保持数据
     */
    wordCount.saveAsTextFile("data/wordcount")
    /**
     * words.map(word =>(word,1)).reduceByKey((x:Int,y:Int)=>x+y).foreach(println)
     * 下面这种形式的代码是上面代码的简写
     */
    //words.map((_,1)).reduceByKey(_+_).foreach(println)
  }
}
