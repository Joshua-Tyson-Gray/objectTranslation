package transformations;

/**
 * Provides a basic representation of a point in space with an x, y, and z coordinate.
 * 
 * @author Joshua Gray
 *
 */
public class Point {
	private double x;
	private double y;
	private double z;

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns the x value of the given Point3D.
	 * 
	 * @return x value
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the y value of the given Point3D
	 * 
	 * @return y value
	 */
	public double getY() {
		return y;
	}

	/**
	 * Returns the z value of the given Point3D
	 * 
	 * @return
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * Sets x value to <code>xVal</code>;
	 * @param x
	 */
	public void setX(double xVal) {
		this.x = xVal;
	}
	
	/**
	 * Sets y value to <code>yVal</code>;
	 * @param y
	 */
	public void setY(double yVal) {
		this.y = yVal;
	}
	
	/**
	 * Sets z value to <code>zVal</code>;
	 * @param z
	 */
	public void setZ(double zVal) {
		this.z = zVal;
	}
	
	public void setCoordinates(double xVal, double yVal, double zVal) {
		this.x = xVal;
		this.y = yVal;
		this.z = zVal;
	}
	
	public double getByCoordinate(char c) {
		if(c == 'X') return x;
		else if(c == 'Y') return y;
		else if(c == 'Z') return z;
		else throw new IllegalArgumentException();
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}

