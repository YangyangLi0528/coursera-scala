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

/*
二叉树  binary-tree
 */
abstract class IntSet{
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
}

class Empty extends IntSet{
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false
}

class NonEmpty(elem:Int,left:IntSet,right: IntSet) extends IntSet{
  override def incl(x: Int): IntSet =
    if(x < elem) new NonEmpty(elem,left incl x,right)
    else if(x>elem)new NonEmpty(elem,left,right incl x)
    else this

  override def contains(x: Int): Boolean =
    if(x < elem) left contains(x)
    else if(x > elem) right contains(x)
    else true

}

abstract class Base{
  def foo = 1
  def bar : Int
}

class Sub extends Base{
  override def foo: Int = 3
  def bar =3
}

object Emptys extends IntSet{
  override def incl(x: Int): IntSet = new NonEmpty(x,Emptys,Emptys)

  override def contains(x: Int): Boolean = false
}

