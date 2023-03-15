package qt.test_example

import scala.io.Source

/**
 * 1、统计各年龄段的人数
 */
object Class_Number_col {
  def main(args: Array[String]): Unit = {
    //读取文件，并将数据以集合的形式存在
    val list: List[String] = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\data\\datas\\students.txt").getLines().toList

    //取年龄字段
    list
      //对每一行数据做处理
      .map((str: String) => {
        val strings: Array[String] = str.split(",")
        strings.slice(2, 3).head
      })
      //对指定字段分组
      .groupBy((i: String) => i)
      //按照分组结果，计算各年龄段人数
      .map((kv: (String, List[String])) => {
        val age_Fanwei = kv._1
        val age_Num: Int = kv._2.size
        (age_Fanwei, age_Num)
      })
      .foreach(println)
  }
}
