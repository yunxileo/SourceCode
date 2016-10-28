import org.apache.spark.{SparkContext, SparkConf}

object testZip{
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //创建环境变量
.setMaster("local")                                                //设置本地化处理
.setAppName("testZip")                                       //设定名称
val sc = new SparkContext(conf)						       //创建环境变量实例
    val arr1 = Array(1,2,3,4,5,6)							       //创建数据集1
    val arr2 = Array("a","b","c","d","e","f")                                //创建数据集1
    val arr3 = Array("g","h","i","j","k","l")                                 //创建数据集1
    val arr4 = arr1.zip(arr2).zip(arr3)                                   //进行亚述算法
    arr4.foreach(print)                                               //打印结果
  }
}
