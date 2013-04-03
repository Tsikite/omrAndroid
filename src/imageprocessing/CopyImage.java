
package imageprocessing;

import android.graphics.Bitmap;

public class CopyImage
{
	private Bitmap newImage;

	public CopyImage(Bitmap buffImage)
	{
		newImage = Bitmap.createBitmap(buffImage.getWidth(), buffImage.getHeight(), Bitmap.Config.ARGB_8888);
		for (int x = 0; x < buffImage.getWidth(); x += 1)
		{
			for (int y = 0; y < buffImage.getHeight(); y += 1)
			{
				int pix = buffImage.getPixel(x, y);
				newImage.setPixel(x, y, pix);
			}
		}
	}

	public Bitmap getCopyOfImage()
	{
		return newImage;
	}

}
