import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object irisCorrect {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("irisCorrect3 ")                                    //设定名称
    val sc = new SparkContext(conf)                                //创建环境变量实例
    val dataX = sc.textFile("c://x.txt")                                //读取数据
        .flatMap(_.split(' ')                                         //进行分割
        .map(_.toDouble))                                         //转化为Double类型
    val dataY = sc.textFile("c://y.txt")                                 //读取数据
      .flatMap(_.split(' ')                                            //进行分割
      .map(_.toDouble))                                           //转化为Double类型
    val correlation: Double = Statistics.corr(dataX, dataY)         //计算不同数据之间的相关系数
    println("setosa和versicolor中Sepal.Length的相关系数为：" + correlation) //打印相关系数                                      
  }
}
