package base

object Apply_Funcation {
  def main(args: Array[String]): Unit = {
    val units = demo1.apply("1", "lisa")
    println(units)
  }
}

object DiaoYong{
  val lisa = new BeiDiaoYong("1", "lisa")

  def apply(ids:String,names:String): BeiDiaoYong = {
    new BeiDiaoYong(ids,names)
  }
}
class BeiDiaoYong(id:String,name:String){override def toString:String=s"id:${id},name:${name}"}
