package de.dhbw.evolution;

import de.dhbw.evolution.generic.Solution;
import de.dhbw.evolution.generic.Vector;

/**
 *
 * @author Benedict Etzel <developer@beheh.de>
 * @author Matthias Welscher
 */
public class GlueThreshold {

	static final int ATTEMPT_STEPS = 100;
	static final int ITERATIONS = 100;
	static final float INITIAL_THRESHOLD = 20f;
	static final float THRESHOLD_DECAY = 0.995f;

	static final Vector INITIAL = new Vector(0.4, 0.2, 0.3);
	static final Vector GOAL = new Vector(0.5, 0.8, 0.2);

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("initial vector is X" + INITIAL);
		System.out.println("goal vector is Z" + GOAL);

		Solution currentSolution = new Solution(INITIAL, getScore(makeGlue(INITIAL)));
		Solution refSolution = currentSolution;

		System.out.println("starting threshold algorithm");

		float threshold = INITIAL_THRESHOLD;

		int j = 0;
		boolean is_worse = true;
		while (is_worse) {
			is_worse = false;
			for (int i = 0; i < ATTEMPT_STEPS; i++) {
				// determine new solution, close to current one
				Vector newVector = mutate(currentSolution.getInputVector());
				Solution newSolution = new Solution(newVector, getScore(makeGlue(newVector)));

				// compare solution to reference solution
				if (newSolution.getScore() > refSolution.getScore()) {
					refSolution = newSolution;
				}

				// check for improvement compared to previous value
				double difference = newSolution.getScore() - currentSolution.getScore();
				if (difference > -threshold) {
					currentSolution = newSolution;
					if (difference < 0) {
						is_worse = true;
					}
				}
			}

			// decay threshold
			threshold *= THRESHOLD_DECAY;

			if ((j % 100) == 0) {
				System.out.println("X" + refSolution.getInputVector() + " -> Z" + makeGlue(refSolution.getInputVector()) + " -> " + makeGlue(refSolution.getInputVector()).getDistance(GOAL));
			}
			j++;

		}
		System.out.println("threshold algorithm finished");
		Vector glueVector = makeGlue(refSolution.getInputVector());
		System.out.println("best solution is: Trel = " + refSolution.getInputVector().getX() + ", cB = " + refSolution.getInputVector().getY() + ", cX = " + refSolution.getInputVector().getZ());
		System.out.println("corresponds to: te = " + glueVector.getX() + ", fe = " + glueVector.getY() + ", vi = " + glueVector.getZ());
	}

	/**
	 *
	 * @param x
	 * @return
	 */
	private static Vector makeGlue(Vector x) {
		double trel = x.getX();
		double cb = x.getY();
		double cx = x.getZ();

		double te = Math.pow(Math.E, -trel * 1.2d) + 0.2 * cx - 0.8 * Math.pow(cb, 2);
		double fe = 1 + 0.5 * trel - 0.7 * Math.pow(cx, 3);
		double vi = 1 - 0.3 * trel + 2.0 * cx;

		return new Vector(te, fe, vi);
	}

	/**
	 * Randomly mutate the vector.
	 *
	 * @param oldVector the vector to mutate
	 * @return the mutated vector
	 */
	private static Vector mutate(Vector oldVector) {
		double newX = oldVector.getX() + (Math.random() * 2 - 1) / 100;
		double newY = oldVector.getY() + (Math.random() * 2 - 1) / 100;
		double newZ = oldVector.getZ() + (Math.random() * 2 - 1) / 100;
		return new Vector(newX, newY, newZ);
	}

	/**
	 *
	 * @param vector
	 * @return
	 */
	private static double getScore(Vector vector) {
		// since we are looking for the minimum distance, the score is negative distance
		return -vector.getDistance(GOAL);
	}

}
