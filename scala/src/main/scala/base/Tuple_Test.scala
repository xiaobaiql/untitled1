package base

/**
 * 元组：固定长度集合
 * 可以通过下划线加上下标获取数据, 可以避免下标越界异常
 * 元组最多只能存22个元素
 */
object Tuple_Test {
  def main(args: Array[String]): Unit = {
    //定义一个只有6个元素的元组
    val tuple = Tuple6(1, 2, 3, 4, 5, 6)
    println(tuple._4)

    //元组简写
    val tuple1 = (1, 2, 3, 4, 5, 6)
  }
}
