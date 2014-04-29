package de.dhbw.evolution.glue;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author benedict
 */
public class Vector {

	private double x;
	private double y;
	private double z;

	private final DecimalFormat format;

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Vector subtract(Vector vector) {
		return new Vector(x - vector.getX(), y - vector.getY(), z - vector.getZ());
	}

	public double getAbs() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}

	public double getDistance(Vector vector) {
		Vector distanceVector = subtract(vector);
		return distanceVector.getAbs();
	}

	public String print(int digits) {
		format.setMaximumFractionDigits(digits);
		format.setMinimumFractionDigits(digits);
		return "(" + format(x) + ", " + format(y) + ", " + format(z) + ")";
	}

	@Override
	public String toString() {
		return print(4);
	}

	private String format(double n) {
		String result = format.format(n);
		if (n >= 0) {
			result = "+" + result;
		}
		return result;
	}
}
