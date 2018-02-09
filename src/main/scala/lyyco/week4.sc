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
