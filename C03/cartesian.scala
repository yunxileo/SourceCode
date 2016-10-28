import org.apache.spark.{SparkContext, SparkConf}

object Cartesian{
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //创建环境变量
.setMaster("local")                                                //设置本地化处理
.setAppName("Cartesian ")                                    	   //设定名称
    val sc = new SparkContext(conf)						       //创建环境变量实例
    var arr = sc.parallelize(Array(1,2,3,4,5,6))						  //创建第一个数组
    var arr2 = sc.parallelize(Array(6,5,4,3,2,1))						  //创建第二个数据
    val result = arr.cartesian(arr2)                                     //进行笛卡尔计算
    result.foreach(print)                                              //打印结果
  }
}
