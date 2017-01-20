package collidables;

import sprites.Sprite;

/**
 * Before collision detection. The position and velocity of the Collidable 
 * shall be updated.
 * @author keping
 *
 */
public abstract class Collidable {
	
	/**
	 * The sprite where this Collidable belongs.
	 */
	protected Sprite s;
	
	public Collidable(Sprite sprite) {
		this.s = sprite;
	}
	
	public double vx() { return s.vx(); }
	public double vy() { return s.vy(); }
	public double m() { return s.m(); }
	public Sprite sprite() { return s; }
	
	/**
	 * [a0, a1] or [a1, a0]. [b0, b1] or [b1, b0]
	 * 
	 * @param a0
	 * @param a1
	 * @param b0
	 * @param b1
	 * @return
	 */
	public static boolean intervalIntersect(double a0, double a1, double b0, double b1) {
		// make sure a0 <= a1 and b0 <= b1
		if (a0 > a1) {
			double aTmp = a0;
			a0 = a1;
			a1 = aTmp;
		}
		if (b0 > b1) {
			double bTmp = b0;
			b0 = b1;
			b1 = bTmp;
		}
		return !(a1 < b0 || b1 < a0);
	}
	
	protected double collisionTimeSpec(VLine vl) { return -1; }
	protected double collisionTimeSpec(HLine hl) { return -1; }
	protected double collisionTimeSpec(Circle circle) { return -1; }
	public abstract double collisionTime(Collidable other);	
	
	protected void collidesSpec(VLine vl) { }
	protected void collidesSpec(HLine hl) { }
	protected void collidesSpec(Circle circle) { }
	public abstract void collides(Collidable other);
}
