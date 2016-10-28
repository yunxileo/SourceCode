import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils

object irisDecisionTree {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("irisDecisionTree ")                              	//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLibSVMFile(sc, "c://a.txt")				//输入数据集
    val numClasses = 3 										//设定分类数量
    val categoricalFeaturesInfo = Map[Int, Int]()					//设定输入格式
    val impurity = "entropy"									//设定信息增益计算方式
    val maxDepth = 5										//设定树高度	
    val maxBins = 3											//设定分裂数据集
    val model = DecisionTree.trainClassifier(data, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)								//建立模型
    val test = Vectors.dense(Array(7.2,3.6,6.1,2.5))
    println(model.predict(“预测结果是:” + test))
   }
}
