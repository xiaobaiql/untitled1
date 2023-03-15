package base

import com.alibaba.fastjson.{JSON, JSONObject}

import scala.io.Source

/**
 * 解析json格式的数据
 *
 * 第三方解析json工具  fastJson  Gson
 */
object FastJson_Test {
  def main(args: Array[String]): Unit = {
    //读取文件
    val list: List[String] = Source.fromFile("D:\\coding\\java_project\\untitled\\data\\user.json").getLines().toList

    //将读取到的数据拼成字符串
    val jsonStr = list.mkString("\n")
    println(list.mkString("\n"))

    /**
     * 使用FastJson解析json格式的数据
     *
     */
    val jSONArray = JSON.parseArray(jsonStr)
    var index = 0
    while (index < jSONArray.size()) {
      //通过下标获取每一个用户
      val userObject: JSONObject = jSONArray.getJSONObject(index)
      //通过列名获取列值
      val name: String = userObject.getString("name")
      val age: String = userObject.getString("age")
      println(s"$name\t$age")
      index += 1
    }
  }
}
