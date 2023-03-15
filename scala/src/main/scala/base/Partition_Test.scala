package base

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
object Partition_Test {
  def main(args: Array[String]): Unit = {
    //spark所需配置
    val conf = new SparkConf()
    conf.setAppName("分区测试")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    //读取文件
    val words: RDD[String] = sc.textFile("D:\\coding\\java_project\\untitled\\data\\基础信息.txt", 4)
    println(s"wordsRDD的分区数：${words.getNumPartitions}")

    //拆分单词
    val words1: RDD[String] = words.flatMap(line => line.split(","))
    println(s"words1RDD的分区数：${words1.getNumPartitions}")

    //分组
    val result: RDD[(String, Int)] = words1.groupBy(word => word, numPartitions = 9)
      .map {
        case (word: String, iter: Iterable[String]) =>
          (word, iter.size)
      }
    println(s"resultRDD的分区数：${result.getNumPartitions}")
    Thread.sleep(5000)
  }
}
