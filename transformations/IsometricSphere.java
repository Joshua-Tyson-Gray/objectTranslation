package transformations;

/**
 * Creates an Isometric Sphere characterized by the Golden Ratio.
 * @author Gray
 *
 */
public class IsometricSphere extends Entity{
	
	public IsometricSphere() {
		verticies = new Point[12];
		double edgeHeight = 100;
		double edgeWidth = 161.803398875;
		
		verticies[0] = new Point(0, -edgeWidth / 2, edgeHeight / 2);
		verticies[1] = new Point(0, -edgeWidth / 2, -edgeHeight / 2);
		verticies[2] = new Point(0, edgeWidth / 2, edgeHeight / 2);
		verticies[3] = new Point(0, edgeWidth / 2, -edgeHeight / 2);
		
		verticies[4] = new Point(edgeHeight / 2, 0, edgeWidth / 2);
		verticies[5] = new Point(edgeHeight / 2, 0, -edgeWidth / 2);
		verticies[6] = new Point(-edgeHeight / 2, 0, edgeWidth / 2);
		verticies[7] = new Point(-edgeHeight / 2, 0, -edgeWidth / 2);
		
		verticies[8] = new Point(-edgeWidth / 2, edgeHeight / 2, 0);
		verticies[9] = new Point(-edgeWidth / 2, -edgeHeight / 2, 0);
		verticies[10] = new Point(edgeWidth / 2, edgeHeight / 2, 0);
		verticies[11] = new Point(edgeWidth / 2, -edgeHeight / 2, 0);
		
	}
}
