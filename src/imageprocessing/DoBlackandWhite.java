

package imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class DoBlackandWhite
{
	private Bitmap buffImage;
	
	public DoBlackandWhite(Bitmap buffImage)
	{
		this.buffImage = buffImage;
	}
	
	public void doBW()
	{
		for (int i=0; i<buffImage.getHeight(); i+=1)
			for (int j=0; j<buffImage.getWidth(); j+=1)
			{
				Log.d("bwprocess",i+":"+j+"  "+buffImage.getHeight()+","+buffImage.getWidth());
				int pix = buffImage.getPixel(j, i);
				//if it's not a black or white pixel, set it to white
				if (pix != Color.WHITE && pix != Color.BLACK)
					buffImage.setPixel(j, i, Color.BLACK);
			}
		
		for (int i=1; i<buffImage.getWidth()-1; i+=1)
			for (int j=1; j<buffImage.getHeight()-1; j+=1)
			{
				if (buffImage.getPixel(i, j) == 0)
				{
					int p1 = buffImage.getPixel(i-1, j-1);
					int p2 = buffImage.getPixel(i-1, j);
					int p3 = buffImage.getPixel(i-1, j+1);
					int p4 = buffImage.getPixel(i, j-1);
					int p5 = buffImage.getPixel(i, j+1);
					int p6 = buffImage.getPixel(i-1, j-1);
					int p7 = buffImage.getPixel(i-1, j);
					int p8 = buffImage.getPixel(i-1, j+1);
				
					if (p1==-1 && p2==-1 && p3==-1 && p4==-1 && p5==-1 && p6==-1 && p7==-1 && p8==-1)
					{
						buffImage.setPixel(i, j, -1);
					}
				}
			}
	}
	public Bitmap getBW(){
		doBW();
		return buffImage;
	}
}
