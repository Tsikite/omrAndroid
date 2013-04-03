

package fft;


public class Complex
{
	private double real[][];
	private double imag[][];

	public Complex(int size)
	{
		real = new double[size][size];
		imag = new double[size][size];
	}

	public void setReal(int x, int y, double real)
	{
		this.real[x][y] = real;
	}

	public void setImag(int x, int y, double imag)
	{
		this.imag[x][y] = imag;
	}

	public double getReal(int x, int y)
	{
		return real[x][y];
	}

	public double getImag(int x, int y)
	{
		return imag[x][y];
	}
}
