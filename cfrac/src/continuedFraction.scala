

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