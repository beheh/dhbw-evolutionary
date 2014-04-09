package de.dhbw.evolution.threshold;

import java.text.DecimalFormat;

/**
 *
 * @author Benedict Etzel <developer@beheh.de>
 */
public class Solution {

	private double x;
	private double y;

	public Solution(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getValue() {
		return (20 + x * x + y * y - 10 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y)));
	}

	public double getScore() {
		return -getValue();
	}

	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00000");
		return ("f(" + format.format(x) + ", " + format.format(y) + ") = " + format.format(this.getValue()));
	}
}
