trait ContinuedFraction
{
	def getIntPart: Int
	def getConvergent: Int
	def getNext: ContinuedFraction
	
	override def toString: String = "[" + getIntPart + "; " + render(1000) + "]"
	
	def render(invertedEpsilon: Int): String =
	{
		if (getConvergent > invertedEpsilon)
		{
			"0"
		}
		else
		{
			getConvergent + ", " + getNext.render(invertedEpsilon)
		}
	}
}


class FloatCfrac(f: Double) extends ContinuedFraction
{
	def getIntPart: Int = 
		if (f > 1) f.floor.toInt
		else 0
	
	private def getFracPart: Double = f - f.floor
	
	override def getConvergent: Int = (1.0 / getFracPart).toInt
	
	override def getNext: ContinuedFraction =
	{
		if (getFracPart == 0)
			CFracZero
		else
		{
			val d = (1.0 / getFracPart)
			new FloatCfrac(d - d.floor)
		}
	}
}


object CFracZero extends ContinuedFraction
{
	def getIntPart: Int = 0
	def getConvergent: Int = 0
	def getNext: ContinuedFraction = CFracZero
	override def render(i: Int): String = "0"
}


object cfrac
{
	def main(args: Array[String]): Unit =
	{
		//println("Hello, world!")
		println(new FloatCfrac(9/16))
		println(new FloatCfrac(2.3456))
		println(new FloatCfrac(3.14159265392))
	}
}