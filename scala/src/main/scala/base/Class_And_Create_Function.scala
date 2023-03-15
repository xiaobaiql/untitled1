package base

object class_and_create_function{
  def main(args: Array[String]): Unit = {
    //默认的构造函数
    val lisa = new demo("1", "lisa", 20)
    lisa.print1()

    //重构的构造函数
    val jake = new demo("2", "jake", 34, 89)
    jake.print2()

    val tom : Object = new demo("3", "tom", 23, 22)
   //println(tom.toString)
   println(tom.toString)
  }
}

//创建一个父类
class demo(id: String, name: String, age: Int) {
  var _id: String = id
  var _name: String = name
  var _age: Int = _
  var _score:Double=_

  /**
   * 重载构造方法
   */
  def this(id: String, name: String, age: Int,score:Double){
    this(id,name,age)
    this._score=score
  }

  /**
   * 在类中定义打印的方法
   */
  def print1(): Unit = {
    println(s"${_id},${_name},${_age}")
  }
  def print2(): Unit ={
    println(s"${_id},${_name},${_age},${_score}")
  }

  /**
   * 重写父类中的方法
   * 重写toString方法
   */
  //override def toString: String = {
  // s"demo(id:${_id},name:${_name},age:${_age},score:${_score})"
  //}
}
