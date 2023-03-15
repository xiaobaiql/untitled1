package base

/**
 * 面向对象编程 - 将对象传来传去
 * 1、以对象作为参数
 * 2、以对象作为返回值
 * 需要明确参数的类型，返回值的类型和对象的类型   - 可以使用多态（父类的引用指向子类的对象）
 *
 * 面向函数编程-- 将函数传来传去  - 高阶函数
 * 1、以函数作为参数  （必须要很熟练）
 * 2、以函数作为返回值 （了解）
 * 需要明确函数的类型
 *
 * lambda表达式(匿名函数)
 *
 * 函数的类型-- 由函数参数类型和返回值类型决定
 * strToInt是一个参数为String返回值为Int类型的函数
 *
 * 函数类型的表示  ：String => Int， 前面是参数类型，后面是返回值类型
 *
 */
object Face_Function_Coding {
  def main(args: Array[String]): Unit = {
    //定义一个函数
    def strToInt(str:String):Int={
      str.toInt
    }

    println(strToInt("100"))

    //scala中函数也是一个对象，可以被引用
    //String=>Int String是参数，Int是返回值
    val strToIntYinYong:String=>Int =strToInt
    println(strToIntYinYong("200"))

    /**
     * 1、函数作为参数
     * fun的参数是一个函数（是一个参数为String返回值Int类型的函数）
     * 以函数作为参数编程的作用--- 我们可以将一个代码逻辑中需要变化的部分抽象出来，让调用者以函数的形式传递进来
     */
    //定义一个被当作参数的函数
    def f(str:String):Int=str.toInt

    //定义一个将函数当作参数的函数
    def fun1(f:String=>Int):Int=f("1000")

    //调用fun1
    println(fun1(f))

    /**
     * lambda表达式（匿名函数：没有名字的函数）
     * (s: String) => s.toInt
     * 前面是参数，后面是函数体和返回值，默认最后一行作为返回值
     * lambda表达式返回值的类型会自动推断
     */
    //使用lambda表达式定义函数,利用f3指向匿名函数,匿名函数函数体只有一行时，可以不加大括号
    val f3 =(s:String)=>s.toInt*2

    println(fun1(f3))

    //将匿名函数作为参数传入
    println(fun1((s: String) => s.toInt * 10))

    //lambda表达式的参数类型可以自动推断,即根据函数fun1所需的参数类型可以自动判断lambda表达式的参数类型
    println(fun1(s => s.toInt))

    def ff(s:Int):String=s.toString
    def fun2(f:Int=>String)=f(10)

    //正常函数
    println(fun2(ff))
    println("=" * 10)
    //匿名函数
    println(fun2(s => s.toString))

    //当某一个参数只用一次，且出现两次，可以再次简写
    println(fun2(_.toString))
  }
}
