import org.apache.spark.{SparkContext, SparkConf}

object countByKey{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("countByKey ")                                    	  //设定名称
    val sc = new SparkContext(conf)						       //创建环境变量实例
    var arr = sc.parallelize(Array((1, "cool"), (2, "good"), (1, "bad"), (1, "fine")))  //创建数据集
    val result = arr.countByKey()                                      //进行计数
    result.foreach(print)                                              //打印结果
  }
}
