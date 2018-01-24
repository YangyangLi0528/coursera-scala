class Rationalss(x:Int,y:Int){
  /*
  auxiliary constructor
   */
  def this(x:Int)=this(x,1)
  require(y>0,"denominator must be positive")
  private def gcd(a:Int,b:Int):Int =
    if(b==0)a else gcd(b,a%b)
  val numer = x /gcd(x,y)
  val denom = y /gcd(x,y)

  def less(that:Rationalss)=
    this.numer*that.denom<that.numer*this.denom

  def max(that:Rationalss)=
    if(this.less(that))that else this
}
new Rationalss(1,2).numer
new Rationalss(1,2).less(new Rationalss(2,3))