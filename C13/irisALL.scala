import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object irisALL{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("irisAll ")                                          //设定名称
    val sc = new SparkContext(conf)                                  //创建环境变量实例
    val data = sc.textFile("c:// Sepal.Length.txt")                        //创建RDD文件路径
.map(_.toDouble))                                             //转成Double类型
      .map(line => Vectors.dense(line))                                //转成Vector格式
val summary = Statistics.colStats(data)						  //计算统计量
println("全部Sepal.Length的均值为：" + summary.mean)		      //打印均值
println("全部Sepal.Length的方差为：" + summary.variance)	      //打印方差
  }
}
