package base

import java.sql.{DriverManager, PreparedStatement, ResultSet}
/**
 * 利用scala连接数据库并向表中插入数据
 */
object Mysql_Connection {
  def main(args: Array[String]): Unit = {
    //需要先在pom中增加mysql驱动的依赖
    Class.forName("com.mysql.cj.jdbc.Driver")

    //建立数据库的连接
    val con = DriverManager.getConnection("jdbc:mysql://localhost/test_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "123456")

    //3、编写sql插入数据
    val stat = con.prepareStatement("insert into student(id,name,age,gender,class) values(?,?,?,?,?)")

    stat.setLong(1,2022040007)
    stat.setString(2,"尹晓派")
    stat.setInt(3,21)
    stat.setString(4,"男")
    stat.setString(5,"文科二班")

    //插入数据
    stat.executeUpdate()

    //读取插入的数据
    //3、编写sql查询数据
    val stat1: PreparedStatement = con.prepareStatement("select * from student where class=?")

    //4、给参数赋值
    stat1.setString(1, "文科二班")

    //5、执行查询
    val resultSet: ResultSet = stat1.executeQuery()

    //6、解析数据
    while (resultSet.next()) {
      //通过列名取出数据
      val id: Long = resultSet.getLong("id")
      val name: String = resultSet.getString("name")
      val age: Long = resultSet.getLong("age")
      val gender: String = resultSet.getString("gender")
      val clazz: String = resultSet.getString("class")
      println(s"$id\t$name\t$age\t$gender\t$clazz")
    }

    //关闭连接
    stat.close()
    con.close()
  }
}
