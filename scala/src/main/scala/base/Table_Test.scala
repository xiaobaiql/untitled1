package base

import org.apache.spark.sql.{DataFrame, SparkSession}

object Table_Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .appName("test1")
      //.config("spark.sql.shuffle.partitions", 1)
      .master("local")
      .getOrCreate()

    import spark.implicits._
    import org.apache.spark.sql.functions._
    //读取数据
    spark
      .read
      .format("csv")
      .option("sep", ",")
      .schema("DEPTNAME1 STRING,DEPTNAME2 STRING,DEPTNAME3 STRING,COST_CENTER STRING,NAME STRING")
      .load("D:\\coding\\java_project\\untitled\\data\\基础信息.txt")
      .show()
  }
}
