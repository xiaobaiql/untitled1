package base

/**
 * 2、以函数作为返回值
 */
object Function_As_Return_value {
  def main(args: Array[String]): Unit = {
    //定义一个返回值类型为函数的的函数
    def fun(f: String => Int): String => Int = {
      println("fun")
      f
    }

    //fun参数和返回值都是一个函数
    //参数一个参数为String返回值为Int类型的函数
    //返回值是一个参数为String返回值Int类型的函数
    val funTemp: (String => Int) => (String => Int) = fun
    //传入一个函数返回一个函数
    val function: String => Int = fun((s: String) => s.toInt)

    def fun1(str: String): String => Int = {
      //定义一个参数为String返回值为Int类型的函数
      def f(s: String): Int = {
        //在函数内使用函数外的变量（闭包）
        s.toInt + str.toInt
      }
      //返回一个函数
      f
    }

    /**
     * 函数调用过程
     * fun1("100"),参数str="100",带入到函数f中，其中的str参数值为"100"
     * 返回的函数为
     * def f(s: String): Int = {
     *  //在函数内使用函数外的变量（闭包）
     *  s.toInt + "100".toInt
     *  }
     *
     *  然后又调用返回的函数，传入的参数为200，也就是计算"200".toInt+"100".toInt 结果为300
     */
    //调用fun1 传入一个字符串
    val stringToInt: String => Int = fun1("100")


    //再调用返回的函数传入一个字符串
    val i = stringToInt("200")
    println(i)
    //简化调用过程
    val j = fun1("20")("10")
    println(j)

    /**
     * 简写上面的函数   -- 函数柯里化
     */
    def fun2(str: String)(s: String): Int = {
      str.toInt + s.toInt
    }

    val k: Int = fun2("30")("33")
    println(k)

    /**
     * 可以先传递一个参数，后面的参数可以传多次，提高了代码的复用性
     */
    val fun3: String => Int = fun2("1000")
    println(fun3("1"))
    println(fun3("2"))
    println(fun3("3"))

    def fun4(str: String, s: String): Int = {
      str.toInt + s.toInt
    }

    println(fun4("1000", "1"))
    println(fun4("1000", "2"))
    println(fun4("1000", "3"))
    /**
     * 偏应用函数
     */
    //调用函数的时候可以只传一部分参数，会返回一个函数，调用返回的函数再传后面的参数
    //下划线是占位符的作用
    val fun5: String => Int = fun4("1000", _)
    println(fun5("1"))
    println(fun5("2"))
    println(fun5("3"))
  }
}
