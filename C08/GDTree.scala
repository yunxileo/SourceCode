import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
import org.apache.spark.mllib.util.MLUtils

object GDTree {

  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("GDTree")                              			//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLibSVMFile(sc, "c://DTree.txt")				//输入数据集

    val boostingStrategy = BoostingStrategy.defaultParams("Classification")	//创建算法类型
    boostingStrategy.numIterations = 3 							//迭代次数
    boostingStrategy.treeStrategy.numClasses = 2					//分类数目
    boostingStrategy.treeStrategy.maxDepth = 5					//决策树最高层数
    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()	//数据格式
    
val model = GradientBoostedTrees.train(data, boostingStrategy)	//训练模型
  }
}
