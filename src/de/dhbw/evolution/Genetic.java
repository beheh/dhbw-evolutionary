package de.dhbw.evolution;

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
public class Genetic {

	public static void main(String[] args) throws Exception {
		List<Individual> currentGeneration = new ArrayList<>();
		currentGeneration.add(new Individual(new Vector(0.9, 0.9)));
		currentGeneration.add(new Individual(new Vector(0.5, 0.5)));
		currentGeneration.add(new Individual(new Vector(0.25, 0.25)));
		currentGeneration.add(new Individual(new Vector(0.0, 0.0)));
		currentGeneration.add(new Individual(new Vector(0.25, 0.25)));
		currentGeneration.add(new Individual(new Vector(-0.5, -0.5)));
		currentGeneration.add(new Individual(new Vector(-0.9, -0.9)));
		for(int i = 0; i < 1000; i++) {
			currentGeneration.add(new Individual(new Vector(Math.random() * 2 - 1, Math.random() * 2 - 1)));
		}
		for(int i = 0; i < 100; i++) {
			score(currentGeneration); // calculdate fitness value
			print(currentGeneration);
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
			System.out.println("Rank " + (i + 1) + ": " + currentGeneration.get(i));
		}
	}

	private static void score(List<Individual> generation) {
		Iterator<Individual> i = generation.iterator();
		double highestResult = 0;
		while(i.hasNext()) {
			Individual individual = i.next();
			Vector values = individual.getValues();
			double x = values.getX();
			double y = values.getY();
			double result = (20 + x * x + y * y - 10 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y)));
			if(result > highestResult) {
				highestResult = result;
			}
			individual.setResult(result);
		}
		i = generation.iterator();
		while(i.hasNext()) {
			Individual individual = i.next();
			Vector values = individual.getValues();
			individual.setFitness(highestResult - individual.getResult());
			// bad values are bad
			if(Math.abs(values.getX()) > 1) {
				individual.setFitness(0);
			} else if(Math.abs(values.getY()) > 1) {
				individual.setFitness(0);
			}
		}
	}

	private static void mutate(List<Individual> currentGeneration, int generation) {
		Iterator<Individual> i = currentGeneration.iterator();
		while(i.hasNext()) {
			Individual individual = i.next();
			Vector values = individual.getValues();
			if(Math.random() > 0.5) {
				values.setX(values.getX() + (2 * Math.random() - 1) / (generation + 1));
			}
			if(Math.random() > 0.5) {
				values.setY(values.getY() + (2 * Math.random() - 1) / (generation + 1));
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
