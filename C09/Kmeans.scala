import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object Kmeans {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("Kmeans ")                              		//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLibSVMFile(sc, "c://Kmeans.txt")			//输入数据集
val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))
.cache()												//数据处理

    val numClusters = 2										//最大分类数
    val numIterations = 20									//迭代次数
    val model = KMeans.train(parsedData, numClusters, numIterations)	//训练模型
    model.clusterCenters.foreach(println)							//打印中心点坐标

  }
}
