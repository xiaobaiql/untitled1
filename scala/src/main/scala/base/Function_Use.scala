package base

/**
 * 以函数作为参数的应用
 */
object Function_Use {
  def main(args: Array[String]): Unit = {
    //定义一个数组
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /**
     * foreach:循环数组中的元素一个一个传递给后面的函数
     * Any:相当于java中的Object
     */
    //定义一个打印函数
    def pp(i:Int)= print(i+",")

    //调用foreach循环打印数组元素
    /**
     * foreach源码
     *
     * def foreach[U](f: A => U): Unit = {
     *  var i = 0
     *  val len = length
     *  while (i < len) { f(this(i)); i += 1 }
     *  }
     */
    array.foreach(pp)

    //lambda表达式
    array.foreach((i:Int)=> print(i))

    array.foreach(i=>print(i))
    array.foreach(print(_))
  }
}
