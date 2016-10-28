import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}

object SVD {
  def main(args: Array[String]) {				
val conf = new SparkConf()                                   	//创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("SVD ")                                    		//设定名称
val sc = new SparkContext(conf)                                 //创建环境变量实例

    val data = sc.textFile("c://a.txt")                                   //创建RDD文件路径
      .map(_.split(' ')                                               //按“ ”分割
      .map(_.toDouble))                                            //转成Double类型
      .map(line => Vectors.dense(line))                               //转成Vector格式

    val rm = new RowMatrix(data)                                    //读入行矩阵
    val SVD = rm.computeSVD(2, computeU = true)					 //进行SVD计算
println(SVD)											 //打印SVD结果矩阵
  }
}

