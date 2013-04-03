

package openomr.omr_engine;

public class StavePeaks
{
	private int peakPos;
	private int peakValue;
	private int start;
	private int end;

	public StavePeaks(int pos, int value)
	{
		this.peakPos = pos;
		this.peakValue = value;
	}

	public void SetStart(int start)
	{
		this.start = start;
	}

	public void SetEnd(int end)
	{
		this.end = end;
	}

	public void setStartEnd(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	// method to test whether two objects are equal
	public boolean equals(StavePeaks x)
	{
		if (x.peakPos == this.peakPos && x.peakValue == this.peakValue && x.start == this.start && x.end == this.end)
			return true;
		return false;
	}

	public int getPos()
	{
		return peakPos;
	}

	public int getValue()
	{
		return peakValue;
	}

	public int getStart()
	{
		return start;
	}

	public int getEnd()
	{
		return end;
	}
}
