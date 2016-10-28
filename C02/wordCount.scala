import org.apache.spark.{SparkContext, SparkConf}
object wordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("wordCount")	//创建环境变量
    val sc = new SparkContext(conf)								//创建环境变量实例
    val data = sc.textFile("c://wc.txt")								//读取文件
    data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)	//word计数
  }
}
