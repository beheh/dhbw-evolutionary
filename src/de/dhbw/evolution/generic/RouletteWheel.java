package de.dhbw.evolution.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author benedict
 * @param <E>
 */
public class RouletteWheel<E> {

	private static final long serialVersionUID = 1L;

	List<Pair<E, Double>> objects = new ArrayList<>();

	public void add(E e, double width) {
		objects.add(new Pair<>(e, width));
	}

	public E spin() {
		double entireWidth = 0;
		Iterator<Pair<E, Double>> i = objects.iterator();
		while(i.hasNext()) {
			Pair<E, Double> p = i.next();
			entireWidth += p.getB();
		}
		boolean allZero = false;
		if(entireWidth == 0) {
			allZero = true;
			entireWidth = 1;
		}
		double pointer = Math.random() * entireWidth;
		double current = 0;
		E result = null;
		i = objects.iterator();
		while(i.hasNext()) {
			Pair<E, Double> p = i.next();
			if(allZero) {
				current += entireWidth / objects.size();
			} else {
				current += p.getB();
			}
			if(current > pointer) {
				result = p.getA();
				break;
			}
		}
		return result;
	}
}
