import org.apache.spark.{SparkContext, SparkConf}

object keyBy{
  def main(args: Array[String]) {
    val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("keyBy ")                                    	  //设定名称
val sc = new SparkContext(conf)						       //创建环境变量实例
    var str = sc.parallelize(Array("one","two","three","four","five"))          //创建数据集
    val str2 = str.keyBy(word => word.size)                              //设置配置方法
    str2.foreach(println)                                               打印结果
  }
}

