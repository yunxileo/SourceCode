import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.{SparkConf, SparkContext}
object FPTree {

  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("FPTree ")                              		//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = sc.textFile("c://fp.txt")								//读取数据
    val fpg = new FPGrowth().setMinSupport(0.3)			//创建FP数实例并设置最小支持度
    val model = fpg.run(data)									//创建模型

  }
}
