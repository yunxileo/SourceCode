import scala.collection.mutable
import scala.io.Source

object Apriori{

  def main(args: Array[String]) {

    val minSup = 2											//设置最小支持度
    val list = new mutable.LinkedHashSet[String]()					//设置可变列表
Source.fromFile("c://apriori.txt").getLines()						//读取数据集并存储
.foreach(str => list.add(str))								//将数据存储
    var map = mutable.Map[String,Int]()							//设置map进行计数
    list.foreach(strss => {										//计算开始
      val strs = strss.split("、")									//分割数据
      strs.foreach(str => {									//开始计算程序
        if(map.contains(str)){									//判断是否存在
          map.update(str,map(str) + 1)							//对已有数据+1
        } else map += (str -> 1)								//将未存储的数据加入
      })
    })

    val tmpMap = map.filter(_._2 > minSup)						//判断最小支持度

    val mapKeys = tmpMap.keySet								//提取清单内容
    val tempList = new mutable.LinkedHashSet[String]()				//创先辅助List
    val conList = new mutable.LinkedHashSet[String]()				//创建连接List
    mapKeys.foreach(str => tempList.add(str))						//进行连接准备
    tempList.foreach(str => {									//开始连接
      tempList.foreach(str2 =>{								//读取辅助List
        if(str != str2){										//判断
          val result = str + "、" + str2							//创建连接字符
          conList.add(result)									//添加
        }
      })
    })

    conList.foreach(strss => {								  //开始对原始列表进行比对
      val strs = strss.split("、")									//切分数据
      strs.foreach(str => {									//开始计数
        if(map.contains(str)){									//判断是否包含
          map.update(str,map(str) + 1)							//对已有数据+1
        } else map += (str -> 1)								//将未存储的数据加入
      })
    })
  }
}
