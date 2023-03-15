package qt.test_example

import scala.io.Source

/**
 * 统计各学生的总分
 */
object All_Score {
  def main(args: Array[String]): Unit = {
    //读取文件
    val score_List = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\data\\datas\\score.txt").getLines().toList


    score_List
      //取出学号，成绩
      .map((i: String) => {
        (i.split(",").head, i.split(",").last.toInt)
      })
      //按照学号分组
      .groupBy((kv: (String, Int)) => kv._1)
      //对分组结果，进行求和
      .map((kv: (String, List[(String, Int)])) => {
        val student_code = kv._1
        val value: List[(String, Int)] = kv._2
        val ints: List[Int] = value.map((u: (String, Int)) => {
          u._2
        })
        val all_score = ints.sum
        (student_code, all_score)
      }).foreach(println)
  }
}
