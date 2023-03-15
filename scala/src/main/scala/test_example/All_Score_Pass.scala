package qt.test_example

import scala.io.Source

/**
 * 3、统计每科都及格的学生
 */
object All_Score_Pass {
  def main(args: Array[String]): Unit = {
    //读取数据
    val toList = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\data\\datas\\score.txt").getLines().toList

    //统计每科都及格的学生
    toList
      .filter(i => {
        i.split(",").last.length <= 3
      }).filter(i => {
      i.split(",").last.toInt >= 60
    }).groupBy(i => i.split(",").head)
      .filter((kv: (String, List[String])) => kv._2.length >= 6)
      .map((kv: (String, List[String])) => {
        (kv._1,kv._2.flatMap((i:String)=> i.split(",").filter((i:String)=>i.length<=3)))
      }
      ).foreach(println)
  }
}
