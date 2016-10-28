import org.apache.spark.{SparkContext, SparkConf}

object CacheTest2 {
  def main(args: Array[String]) {
    val conf = new SparkConf()                                     //创建环境变量
      .setMaster("local")                                           //设置本地化处理
  .setAppName("CacheTest2")								//设定名称
    val sc = new SparkContext(conf)							//创建环境变量实例
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))				//设定数据集
    arr.foreach(println)										//打印结果
  }
}

