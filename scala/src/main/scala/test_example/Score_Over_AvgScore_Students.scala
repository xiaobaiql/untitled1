package qt.test_example

import scala.io.Source

/**
 * 2、统计总分大于年级平均分的学生
 */
object Score_Over_AvgScore_Students {
  def main(args: Array[String]): Unit = {
    //读取数据
    val toList = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\data\\datas\\score.txt").getLines().toList

    //计算总分
    val all_Score: Map[String, Int] = toList
      //取出学号，成绩
      .map((i: String) => {
        var ints = 0
        if (i.split(",").last.length <= 3) {
          ints = i.split(",").last.toInt
        }
        (i.split(",").head, ints)
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
      })

    //计算平均分
    val aLL_Student_Score = all_Score.toList.map((kv: (String, Int)) => kv._2).sum
    val student_Num = all_Score.toList.length
    val i = aLL_Student_Score / student_Num
    println("平均分："+ i)

    println("超出平均分的学生学号，成绩：")
    all_Score.filter((kv:(String,Int))=> {
      kv._2>=i
    }).foreach(println)
  }
}
