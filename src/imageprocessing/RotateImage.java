
package imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class RotateImage
{
	private Bitmap image;
	private float angle;

	public RotateImage(Bitmap buffImage, float angle)
	{
		this.image = buffImage;
		this.angle = angle;
	}

	public Bitmap tilt()
	{
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		Matrix m = new Matrix();
		//m.postScale(neww, newh);
		m.postRotate(angle, w/2, h/2);
		Bitmap result = Bitmap.createBitmap(image, 0, 0, neww, newh, m, true);
		return result;
	}


}
