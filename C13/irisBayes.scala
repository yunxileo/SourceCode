import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object irisBayes {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("irisBayes")                              		//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLabeledPoints(sc,"c://a.txt")				//读取数据集
    val model = NaiveBayes.train(data, 1.0)						//训练贝叶斯模型
val test = Vectors.dense(7.3,2.9,6.3,1.8)						//创建待测定数据
val result = model.predict(“测试数据归属在类别:” + test)			//打印结果
}	
}
