package base

case class demo1(id:String,var name:String,age:Int=0)
object example_class {
  def main(args: Array[String]): Unit = {
    val lisa = new demo1("1", "lisa")
    println(lisa.id)
    println(lisa.name)
    println(lisa.name)
    val dd = demo1("2", "dd", 22)
    dd.name="dd1"
    println(dd)
  }
}
