import org.apache.spark.mllib.feature.Word2Vec
import org.apache.spark.{SparkConf, SparkContext}

object word2Vec {
  def main(args: Array[String]) {
val conf = new SparkConf()                                   	//创建环境变量
.setMaster("local")                                          	//设置本地化处理
.setAppName("word2Vec ")                                    		//设定名称
val sc = new SparkContext(conf)                               	//创建环境变量实例
    val documents = sc.textFile("c://a.txt").map(_.split(" ").toSeq)		//读取数据文件

    val word2vec = new Word2Vec()							//创建词向量实例
    val model = word2vec.fit(data)								//训练模型
    println(model.getVectors)  								//打印向量模型
val synonyms = model.findSynonyms("spar", 2)					//寻找spar的相似词
    for(synonym <- synonyms){								//打印找到的内容
      println(synonym)
    }
  }
}


