import org.apache.spark.mllib.clustering.GaussianMixture
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object irisGMG {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("irisGMG")                              			//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = sc.textFile("c://a.txt")							//输入数个
val parsedData = data.map(s => Vectors.dense(s.trim.split(' ')		//转化数据格式
.map(_.toDouble))).cache()
    val model = new GaussianMixture().setK(2).run(parsedData)		//训练模型

    for (i <- 0 until model.k) {
      println("weight=%f\nmu=%s\nsigma=\n%s\n" format			//逐个打印单个模型
        (model.weights(i), model.gaussians(i).mu, model.gaussians(i).sigma))	//打印结果
    }
  }
}
