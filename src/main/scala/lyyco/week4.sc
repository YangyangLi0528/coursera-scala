import scala.collection.mutable.Map
 abstract class Boolean{
  def ifThenElse[T](t: => T, e: => T): T
  //def && (x: => Boolean): Boolean = ifThenElse(x,false)

}
val oneTwo = List(1,2)
val oneTwoThree = List(1,2,3)
val oneTwoThreeFour = oneTwo ::: oneTwoThree
println(oneTwo+"" +oneTwoThree)
println(oneTwoThreeFour)
val pair = (99,"lyytest")
println(pair._1)
println(pair._2)
var jetSet = Set("Boeing","Airbus")
var sett = jetSet += "Lear"
println(jetSet.contains("Lear"))
val movieSet = Set("lyy","yyl")

var treasureMap = Map[Int,String]()
treasureMap += (1 -> "lyy")

 class ChecksumAccumulator{
   private  var sum = 0
   def add(b:Byte)
     {sum += b}

   def checksum():Int =
      ~(sum & 0xFF) +1

 }
 val acc = new ChecksumAccumulator
def g() {"this String gets lost too"}
 def h() = {"this String gets returned"}

 object ChecksumAccumulator {
   private val cache = Map[String,Int]()
   def calculate(s:String):Int =
     if(cache.contains(s))
       cache(s)
   else{
       val acc = new ChecksumAccumulator
       for(c <- s)
         acc.add(c.toByte)
        val cs = acc.checksum()
       cache += (s -> cs)
       cs
     }
 }
ChecksumAccumulator.calculate("hello world")
(x:Int)=> x *x
class AnonFun extends Function1[Int,Int]{
  def apply(x:Int)=x * x
}
new AnonFun

for(i <- 1 to 10 )System.out.println(i)
def assertAllPos[S <: Int](r:S):S