package qt.test_example

import scala.io.Source

/**
 * 1、统计总分年级排名前十学生各科的分数
 */
object Top_Ten_Students {
  def main(args: Array[String]): Unit = {
    //读取数据
    val toList = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\data\\datas\\score.txt").getLines().toList

    //计算总分
    val stringToInt = toList
      //取出学号，成绩
      .map((i: String) => {
        var ints= 0
        if(i.split(",").last.length<=3){
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
      //map集合转为List集合
      .toList
      //对集合内的数据，按照分数高低排序
      .sortBy((kv:(String,Int))=> -kv._2)
      //取出前10
      .take(10)
      //打印数据
      .foreach(println)
  }
}
