

package openomr.omr_engine;

import android.graphics.Bitmap;
import android.graphics.Color;


/**
 * The <code> XProjection </code> class will calculate the X-Projection of an image. The constructor
 * is given a <code> BufferedImage </code> and then the <code> calcXProjection </method> is invoked
 * to calculate the X-Projection of the <code> BufferedImage </code>.
 * <p>
 * The <code> XProjection </code> class is used as follows:
 * <p> 
 * <code>
 * XProjection xProj = new XProjection(BufferedImage); <br>
 * xProj.calcXProjection(startH, endH, startW, endW); <br>
 * </code>
 * <p>
 * Calling the <code> calcXProjection </code> method will place the X-Projection of the <code> BufferedImage </code>
 * in a int[] array which can be obtained by calling the <code> getYProjection </code> method.
 * <p>
 * 
*/
public class XProjection
{
	private int xProjection[];
	private int size;
	private Bitmap buffImage;
	
	public XProjection(Bitmap buffImage)
	{
		this.buffImage = buffImage;
	}
	
	/**
	 * Cacluate the X-Projection of the BufferedImage
	 * @param startH Desired start Y-Coordinate of the BufferedImage
	 * @param endH Desired end Y-Coordinate of the BufferedImage
	 * @param startW Desired start X-Coordinate of the BufferedImage
	 * @param endW Desired end X-Coordinate of the BufferedImage
	 */
	
	public void calcXProjection(int startH, int endH, int startW, int endW)
	{
		int size = Math.abs(endW - startW) + 1;
		//System.out.println("Size: " + size);
		this.size = size;
		xProjection = new int[size];
		
		for (int i = startW; i < endW; i += 1)
		{
			for (int j = startH; j < endH; j += 1)
			{
				int color = 0;
				try
				{
					color = buffImage.getPixel(i, j);
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					
				}
				if (color != Color.BLACK) //if black pixel
				{
					xProjection[i-startW] += 1;
				}
			}
		}
	}
	
	/**
	 * Returns the resulting X-Projection of the BufferedImage
	 * @return xProjection
	 */
	
	public int[] getXProjection()
	{
		return xProjection;
	}
	
	
	/**
	 * Prints the X-Projection of the BufferedImage
	 *
	 */
	public void printXProjection()
	{
		System.out.println("X Projection");
		for (int i=0; i<size; i+=1)
		{
			System.out.println(xProjection[i]);
		}
		System.out.println("END X Projection");
	}
	
}
