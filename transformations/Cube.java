package transformations;

/**
 * Generates the 8 points of a cube.
 * @author Gray
 *
 */
public class Cube extends Entity{

	public Cube() {
		super();
		verticies = new Point[8];
		verticies[0]= new Point(100,100,100);
		verticies[1]= new Point(100,100,-100);
		
		verticies[2]= new Point(100,-100,100);
		verticies[3]= new Point(100,-100,-100);
		
		verticies[4]= new Point(-100,100,100);
		verticies[5]= new Point(-100,100,-100);
		
		verticies[6]= new Point(-100,-100,100);
		verticies[7]= new Point(-100,-100,-100);
	}
}
