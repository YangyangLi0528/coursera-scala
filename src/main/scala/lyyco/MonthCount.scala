package scala.lyyco

import org.apache.spark.{SparkConf, SparkContext}

object MonthCount {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println("Usage: MyWordCout <input> <output> ")
      System.exit(1)
    }
//    设置一个输入路径。
     val input=args(0)
//    设置一个输出路径。
    val output1=args(1)
    val regex1="2017"
    val regex2="SUCCESS"

    val conf = new SparkConf().setAppName("monthcount")
    val sc = new SparkContext(conf)
//    读取到这个文件，然后以逗号分隔开来。过滤掉时间不为2017，然后再过滤掉交易状态为不成功的场景。
    val rowRdd = sc.textFile("hdfs://192.168.2.106:8020/test/shuju/PAY_PAYMENT_201802281551.csv").map(_.split(","))
      .filter(arr=>arr(20).substring(0,4)!=regex1).filter(arr=>arr(15)!=regex2).cache()

    val searchword = rowRdd.map(line=>{(line(20).substring(0,7),line(15).toDouble)}).reduceByKey(_+_).map(x => (x._2, x._1)).sortBy(_._1,false)
     sc.parallelize(searchword).saveAsTextFile(output1)
     sc.stop()
  }

}
