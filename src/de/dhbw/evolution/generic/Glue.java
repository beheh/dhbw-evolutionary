
package de.dhbw.evolution.generic;

/**
 *
 * @author benedict
 */
public abstract class Glue {
	public static Vector makeGlue(Vector vector) {
		double trel = vector.getX();
		double cb = vector.getY();
		double cx = vector.getZ();

		double te = Math.pow(Math.E, -trel * 1.2d) + 0.2 * cx - 0.8 * Math.pow(cb, 2);
		double fe = 1 + 0.5 * trel - 0.7 * Math.pow(cx, 3);
		double vi = 1 - 0.3 * trel + 2.0 * cx;

		return new Vector(te, fe, vi);
	}
}
