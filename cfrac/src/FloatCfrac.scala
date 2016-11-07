

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