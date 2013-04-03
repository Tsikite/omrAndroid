

package openomr.omr_engine;

public class L2_Segment
{
	private int yPosition; //symbol position along y-axis
	private String symbolName;	//Symbol name as classified by ANN
	private double accuracy;	// % confidence that ANN gave
	
	public L2_Segment(int yPosition, String symbolName, double accuracy)
	{
		this.yPosition = yPosition;
		this.symbolName = symbolName;
		this.accuracy = accuracy;
	}
	
	public void printInfo()
	{
		System.out.printf("Symbol: %s, accuracy: %f\n", symbolName, accuracy);
	}
	
	public int getyPosition()
	{
		return yPosition;
	}
	
	public String getSymbolName()
	{
		return symbolName;
	}
	
	public double getAccuracy()
	{
		return accuracy;
	}
}
