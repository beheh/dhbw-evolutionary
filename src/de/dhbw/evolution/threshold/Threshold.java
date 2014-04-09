package de.dhbw.evolution.threshold;

/**
 *
 * @author Benedict Etzel <developer@beheh.de>
 */
public class Threshold {

	static final int ATTEMPT_STEPS = 100;
	static final int ITERATIONS = 100;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		float threshold = 20f;
		float thresholdDecay = 0.995f;
		Solution currentSolution = new Solution(Math.random() * 2 - 1, Math.random() * 2 - 1);
		Solution refSolution = currentSolution;
		System.out.println("starting at:   " + refSolution);

		int j = 0;
		boolean is_worse = true;
		while(is_worse) {
			is_worse = false;
			for(int i = 0; i < ATTEMPT_STEPS; i++) {
				// determine new solution, close to current one
				Solution newSolution = mutate(currentSolution);

				// compare solution to reference solution
				if(newSolution.getScore() > refSolution.getScore()) {
					refSolution = newSolution;
				}

				// check for improvement compared to previous value
				double difference = newSolution.getScore() - currentSolution.getScore();
				if(difference > -threshold) {
					currentSolution = newSolution;
					if(difference < 0) {
						is_worse = true;
					}
				}

			}

			// decay threshold
			threshold *= thresholdDecay;

			if((j % 100) == 0) {
				System.out.println("currently at:  " + refSolution);
			}
			j++;

		}
		System.out.println("best solution: " + refSolution);
	}

	private static double boundBy(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);
	}

	private static Solution mutate(Solution oldSolution) {
		double newX = oldSolution.getX() + (Math.random() * 2 - 1) / 100;
		double newY = oldSolution.getY() + (Math.random() * 2 - 1) / 100;
		return new Solution(boundBy(newX, -1, 1), boundBy(newY, -1, 1));

	}

}
