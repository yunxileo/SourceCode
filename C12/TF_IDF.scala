import org.apache.spark.mllib.feature.{IDF, HashingTF}
import org.apache.spark.{SparkContext, SparkConf}

object TF_IDF {
  def main(args: Array[String]) {
val conf = new SparkConf()                                   	//创建环境变量
.setMaster("local")                                          	//设置本地化处理
.setAppName("TF_IDF ")                                    		//设定名称
val sc = new SparkContext(conf)                               	//创建环境变量实例
    val documents = sc.textFile("c://a.txt").map(_.split(" ").toSeq)		//读取数据文件

    val hashingTF = new HashingTF()							//首先创建TF计算实例
    val tf = hashingTF.transform(documents).cache()				//计算文档TF值
    val idf = new IDF().fit(tf)									//创建IDF实例并计算

    val tf_idf= idf.transform(tf)									//计算TF_IDF词频
    tf_idf.foreach(println)										//打印结果

  }
}
