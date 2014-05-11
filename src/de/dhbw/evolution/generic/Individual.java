package de.dhbw.evolution.generic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author benedict
 */
public class Individual implements Cloneable {

	private Double fitness;
	private Double result;
	private boolean fitnessSet = false;
	private final Vector values;

	private DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);

	public Individual(Vector values) {
		this.values = values;
		format.setMinimumFractionDigits(4);
		format.setMaximumFractionDigits(4);
	}

	public Vector getValues() {
		return values;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getResult() {
		return result;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
		this.fitnessSet = true;
	}

	public boolean fitnessSet() {
		return fitnessSet;
	}

	public double getFitness() {
		return fitness;
	}

	@Override
	public String toString() {
		String line = "";
		line += values.toString();
		if(result != null) {
			line += " = " + format.format(result);
		}
		if(fitness != null) {
			line += " -> " + format.format(fitness);
		}
		return line;
	}

	@Override
	public Individual clone() throws CloneNotSupportedException {
		Individual i = new Individual(values.clone());
		return i;
	}
}
