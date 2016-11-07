

object CFracZero extends ContinuedFraction
{
	def getIntPart: Int = 0
	def getConvergent: Int = 0
	def getNext: ContinuedFraction = CFracZero
	override def render(i: Int): String = "0"
}