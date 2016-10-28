import org.apache.spark.{SparkContext, SparkConf}

object testRDDMethod2 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //创建环境变量
.setMaster("local")                                                //设置本地化处理
.setAppName("testRDDMethod2 ")                                    	   //设定名称
    val sc = new SparkContext(conf)						       //创建环境变量实例
    val arr = sc.parallelize(Array(1,2,3,4,5,6)，2)				       //输入数组数据集
    val result = arr.aggregate(0)(math.max(_, _), _ + _)				  //使用aggregate方法
    println(result)											  //打印结果
  }
}
