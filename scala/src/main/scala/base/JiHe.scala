package base

/**
 * scala集合
 * 1、List: 有序，不唯一
 * 2、Set ：无序，唯一
 * 3、Map: kv格式   key是唯一的
 * 4、Tuple: 元组，固定长度集合
 *
 */
/**
 * List集合
 * scal的集合比java的集合好用-多了很多的方法
 */
object JiHe {
  def main(args: Array[String]): Unit = {
    //定义一个集合
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,1,2)

    //取list集合的头元素
    println(list.head)

    //取尾元素
    println(list.last)

    //取list集合除头元素外的所有元素
    println(list.tail)

    //取集合中前多少个元素
    println(list.take(4))

    //取集合中倒数第一个往前多少个元素
    println(list.takeRight(4))

    //取集合中的最大值
    println(list.max)

    //取集合中的最小值
    println(list.min)

    //算集合中的平均值
    println(list.sum)

    //对集合中的元素进行去重
    list.distinct.foreach(println(_))

    //将集合内的元素进行反转
    list.reverse.foreach(println(_))

    //将集合内元素以指定字段拼接成字符串
    println(list.mkString("|"))

    /**
     * List集合提供的一些遍历简洁方法和易用的方法
     * 1、foreach：循环集合，将集合中的元素一个一个传递给后面的函数，foreach没有返回值
     * 2、循环集合将集合中的元素一个一个传递给后面的函数，函数的返回值会构建出一个新的集合
     * 3、Filter: 循环集合，将集合中的元素一个一个传递给后面的函数,函数返回一个元素，新集合接收一个元素
     * 4、flatMap: (只适用于由字符类型的数据组成的集合)循环集合中的元素，将袁术一个一个传递给后面的函数,函数返回一个集合，flatMap会将返回的集合拆分出来构建成一个新的集合
     *
     * 多集合排序
     * 1、sortBy: 需要指定一个排序的字段，默认是升序
     * 2、sortWith: 指定一个排序的比较规则
     */
    //遍历list集合
    list.foreach(println)

    /**
     * 给集合内元素都加1
     */
    //正常代码完成
    for (elem <- list) {
      val j=elem+1
      print(j+",")
    }

    //利用map函数完成
    //map函数本质上就是取出集合的一个元素以后就会再返回一个元素
    list.map((i:Int)=>i+1).foreach(println)

    /**
     * 特俗情况，如果集合中有元素为空，我们需要取出不为空的元素，这时只用map函数就不可行，需配合filter函数使用
     * filter函数本质就是一个筛子，里面写上筛选的条件，把符合条件的筛选出来
     */
    //取出集合的偶数
    list.map(_+1).filter(i=>i%2==0).foreach(println)

    /**
     */
    //定义一个字符集合
    val list1 = List("spark,flink,hadoop", "datax,sqoop,kettle", "scala,java,python")
    list1.flatMap((i:String)=>i.split(",")).foreach(println)
    //例如我们要取出java这个字段
    list1.flatMap(
      (i:String)=>{
        i.split(",")
      }
    ).foreach(println)

    /**
     * 多集合排序
     * sortBy: 需要指定一个排序的字段，默认是升序，可以指定排序规则
     * sortWith: 指定一个排序的比较规则
     */
    list.sortBy((i:Int)=> -i).foreach(i=> print(i+","))
    println()
    list.sortWith((i:Int,j:Int)=> i<j).foreach(i=> print(i+","))

    /**
     * groupBy: 分组，需要指定一个分组的字段,会返回一个Map集合
     */
    val words = List("java", "spark", "java", "java", "spark", "hadoop")
    val groupByList: Map[String, List[String]] = words.groupBy((word: String) => word)
    groupByList.foreach(println)

    /**
     * 以下所有的方法都是返回新的集合，不会对原始的集合做任何修改
     * foreach:遍历数据
     * map：一条一条处理数据
     * filter：过滤数据
     * flatMap:将一行转换成多行
     * sortBy：排序
     * groupBy：分组
     */

    /**
     * scala 的Set集合是不会出现重复元素的集合，和Java中的Set集合特性保持一致
     * 同时Set集合 也有上面List集合的一些方法，但是没有sort方法
     */
    val s1 = Set(1, 2, 3, 4, 5, 7, 8)
    val s2 = Set(1, 3, 5, 7, 8, 9, 10)
    println(s1 & s2) //交集
    println(s1 | s2) //并集
    println(s1 &~ s2) //差集
    /**
     * 集合之前的转换
     *
     */
    val list11 = List(1, 2, 2, 3, 2, 1, 2, 4, 5, 6, 7, 8)
    println(list11)
    val listSet = list11.toSet
    println(listSet)
    println(listSet.toList)
  }
}
