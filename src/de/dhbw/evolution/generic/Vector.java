package de.dhbw.evolution.generic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author benedict
 */
public final class Vector implements Cloneable {

	private final int length;

	private final double[] values;

	private DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);

	public Vector(int length) {
		this.length = length;
		this.values = new double[length];
	}

	public Vector(double x, double y) {
		this.length = 2;
		this.values = new double[length];
		setX(x);
		setY(y);
	}

	public Vector(double x, double y, double z) {
		this.length = 3;
		this.values = new double[length];
		setX(x);
		setY(y);
		setZ(z);
	}

	public void set(int i, double x) {
		values[i] = x;
	}

	public void setX(double x) {
		set(0, x);
	}

	public void setY(double y) {
		set(1, y);
	}

	public void setZ(double z) {
		set(2, z);
	}

	public double get(int i) {
		return values[i];
	}

	public double getX() {
		return get(0);
	}

	public double getY() {
		return get(1);
	}

	public double getZ() {
		return get(2);
	}

	public Vector subtract(Vector vector) {
		Vector result = new Vector(length);
		for(int i = 0; i < length; i++) {
			result.set(i, get(i) - vector.get(i));
		}
		return result;
	}

	public double getAbs() {
		double sum = 0;
		for(int i = 0; i < length; i++) {
			sum += Math.pow(get(i), 2);
		}
		return Math.sqrt(sum);
	}

	public double getDistance(Vector vector) {
		Vector distanceVector = subtract(vector);
		return distanceVector.getAbs();
	}

	public String print(int digits) {
		format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
		format.setMaximumFractionDigits(digits);
		format.setMinimumFractionDigits(digits);
		String line = "(";
		for(int i = 0; i < length; i++) {
			if(i != 0) {
				line += ", ";
			}
			line += format(get(i));
		}
		line += ")";
		return line;
	}

	@Override
	public String toString() {
		return print(4);
	}

	private String format(double n) {
		String result = format.format(n);
		if(n >= 0) {
			result = "+" + result;
		}
		return result;
	}

	@Override
	public Vector clone() throws CloneNotSupportedException {
		Vector next = new Vector(length);
		for(int i = 0; i < length; i++) {
			next.set(i, get(i));
		}
		return next;
	}
}
