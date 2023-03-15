package base

import java.io.{FileNotFoundException, FileReader}

object Exception_Test {
  def main(args: Array[String]): Unit = {
    try {
      //先遇到第一个异常，就不走第二个异常
      //val fileReader = new FileReader("data/dsssds")
      val i = 100 / 0
      Class.forName("com.shujia.test")
    } catch {
      case e: FileNotFoundException =>
        println("文件找不到")

      case e: ArithmeticException =>
        println("除数为0")

      case e: RuntimeException =>
        println("运行时异常")

      case e: ClassNotFoundException =>
        println("Class文件找不到")
    } finally {
      println("执行try-catch结束")
    }

    println("代码执行结束")
  }

}
