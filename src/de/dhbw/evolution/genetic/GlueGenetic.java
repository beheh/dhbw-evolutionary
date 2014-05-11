package de.dhbw.evolution.genetic;

import de.dhbw.evolution.generic.Glue;
import de.dhbw.evolution.generic.Individual;
import de.dhbw.evolution.generic.RouletteWheel;
import de.dhbw.evolution.generic.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Benedict Etzel <developer@beheh.de>
 * @author Matthias Welscher
 */
public class GlueGenetic {

	static final Vector GOAL = new Vector(0.5, 0.8, 0.2);

	public static void main(String[] args) throws Exception {
		List<Individual> currentGeneration = new ArrayList<>();
		for(int i = 0; i < 1000; i++) {
			currentGeneration.add(new Individual(new Vector(0.4, 0.2, 0.3)));
		}
		double bestDistance = -1;
		for(int i = 0; bestDistance < 0 || bestDistance > 0.01; i++) {
			score(currentGeneration); // calculdate fitness value
			Iterator<Individual> individualIterator = currentGeneration.iterator();
			Individual bestIndividual = null;
			bestDistance = -1;
			while(individualIterator.hasNext()) {
				Individual individual = individualIterator.next();
				if(bestDistance == -1 || individual.getResult() < bestDistance) {
					bestDistance = individual.getResult();
					bestIndividual = individual;
				}
			}
			print(currentGeneration);
			System.out.println("best individual is currently "+bestIndividual+" (glue is "+Glue.makeGlue(bestIndividual.getValues())+")");
			currentGeneration = selection(currentGeneration);	// birth of new generation
			mutate(currentGeneration, i); // mutate the new generation
		}
		score(currentGeneration); // calculdate fitness value
		Collections.sort(currentGeneration, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				return Double.compare(o2.getFitness(), o1.getFitness());
			}
		});
		System.out.println("Results are");
		for(int i = 0; i < 3; i++) {
			System.out.println("Rank " + (i + 1) + ": " + currentGeneration.get(i) + " (glue is " + Glue.makeGlue(currentGeneration.get(i).getValues()) + ")");
		}
	}

	private static void score(List<Individual> generation) {
		Iterator<Individual> i = generation.iterator();
		double highestResult = 0;
		while(i.hasNext()) {
			Individual individual = i.next();
			Vector values = individual.getValues();
			double result = GOAL.getDistance(Glue.makeGlue(values));
			if(result > highestResult) {
				highestResult = result;
			}
			individual.setResult(result);
		}
		i = generation.iterator();
		while(i.hasNext()) {
			Individual individual = i.next();
			individual.setFitness(Math.pow(highestResult - individual.getResult(), 3));
		}
	}

	private static void mutate(List<Individual> currentGeneration, int generation) {
		Iterator<Individual> i = currentGeneration.iterator();
		while(i.hasNext()) {
			Individual individual = i.next();
			Vector values = individual.getValues();
			if(Math.random() > 0.5) {
				values.setX(values.getX() + (2 * Math.random() - 1) / Math.sqrt(generation + 1));
			}
			if(Math.random() > 0.5) {
				values.setY(values.getY() + (2 * Math.random() - 1) / Math.sqrt(generation + 1));
			}
			if(Math.random() > 0.5) {
				values.setZ(values.getZ() + (2 * Math.random() - 1) / Math.sqrt(generation + 1));
			}
		}
	}

	private static List<Individual> selection(List<Individual> currentGeneration) throws Exception {
		List<Individual> nextGeneration = new ArrayList<>(currentGeneration.size());
		Iterator<Individual> i = currentGeneration.iterator();
		RouletteWheel<Individual> wheel = new RouletteWheel<>();
		while(i.hasNext()) {
			Individual individual = i.next();
			if(!individual.fitnessSet()) {
				throw new Exception("fitness was not set");
			}
			wheel.add(individual, individual.getFitness());
		}
		int size = currentGeneration.size();
		for(int j = 0; j < size; j++) {
			Individual next = wheel.spin().clone();
			nextGeneration.add(next);
		}
		//System.out.println("previous was " + size + ", current is " + nextGeneration.size());
		//System.out.println("first item is a "+nextGeneration.get(0).getClass().toString());
		return nextGeneration;
	}

	private static void print(List<Individual> generation) {
		Iterator<Individual> i = generation.iterator();
		String line = "[";
		int j = 0;
		while(i.hasNext()) {
			Individual individual = i.next();
			if(j != 0) {
				line += ", ";
			}
			line += individual.toString();
			j++;
		}
		line += "]";
		System.out.println(line);
	}

}
