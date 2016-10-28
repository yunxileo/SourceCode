import org.apache.spark.{SparkContext, SparkConf}

object distinct{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("distinct ")                                    	  //设定名称
val sc = new SparkContext(conf)						       //创建环境变量实例
var arr = sc.parallelize(Array(("cool"), ("good"), ("bad"), ("fine"),("good"),("cool")))  //创建数据集
val result = arr.distinct()                                           //进行去重操作
result.foreach(println)                                             //打印最终结果
  }
}
