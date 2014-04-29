package de.dhbw.evolution.glue;

/**
 *
 * @author benedict
 */
public class Solution {

	private final Vector inputVector;
	private final double score;

	public Solution(Vector inputVector, double score) {
		this.inputVector = inputVector;
		this.score = score;
	}

	public double getScore() {
		return score;
	}	

	public Vector getInputVector() {
		return inputVector;
	}

	@Override
	public String toString() {
		return inputVector + " = " + getScore();
	}
}
