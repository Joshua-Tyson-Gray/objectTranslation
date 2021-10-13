package transformations;

public class UVSphere extends Entity{

	/**
	 * Creates a UV sphere.
	 * 
	 */
	public UVSphere(int factor) {
		super();
		
		//Generates a UV Sphere.
		double currentAngle = 0;
		int vertCount = 0;
		int numVerts = (int) (360 / (90.0 / factor) * (360 / (90.0 / factor) / 2 - 1)) + 2;
		
		verticies = new Point[numVerts];
		while(currentAngle <= 90) {
			if(currentAngle == 90) {
				verticies[vertCount++] = new Point(0, 0, 1 * scale);
				verticies[vertCount++] = new Point(0, 0, -1 * scale);
			}else {
				double currentUnit = Math.cos(Math.toRadians(currentAngle));
				double z = Math.sin(Math.toRadians(currentAngle)) * scale;
				for(double i = 0; i < 360; i += 90.0 / factor) {
					double x = Math.cos(Math.toRadians(i)) * currentUnit * scale;
					double y = Math.sin(Math.toRadians(i)) * currentUnit * scale;
					verticies[vertCount++] = new Point(x, y, z);
					if(z != 0) verticies[vertCount++] = new Point(x, y, -z);
				}
			}
			currentAngle += 90.0 / factor;
		}
	}
}
