package transformations;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {
	
	protected Point[] verticies;
	protected int scale;
	
	public float xOffset;
	public float yOffset;
	
	protected double xRotation;
	protected double yRotation;
	protected double zRotation;
	protected double zoom;
	
	public Entity() {
		scale = 300;
		xOffset = 0.0f;
		yOffset = 0.0f;
		xRotation = 0.0;
		yRotation = 0.0;
		zRotation = 0.0;
		zoom = 1;
	}
	
	/**
	 * Renders the sphere to the screen.
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		for(Point p : verticies) {
			//if(p.getZ() < 0) continue;
			double x = p.getX();
			double y = p.getY();
			int newX = (int) ( (x * zoom) + Canvas.worldX + xOffset );
			int newY = (int) ( (y * zoom) + Canvas.worldY + yOffset );
			g.drawLine(newX, newY, newX, newY);
		}
	}
	
	/**
	 * Rotates the object by <code>angle</code> in degrees on the Z axis.
	 * 
	 * @param angle
	 */
	public void rotateZ(double angle) {
		//Updates zRotation variable.
		//zRotation += angle;
		//if(zRotation >= 360 || zRotation <= -360) zRotation = zRotation % 360;
		//if(zRotation == -0) zRotation = 0;
		//Rotates all points in the object.
		for(Point p : verticies) {
			double x = p.getX();
			double y = p.getY();
			double newZAngle = Math.atan(y / x) + Math.toRadians(angle); // newAngle = currentAngle + addedAngle
			double radius = Math.sqrt(x * x + y * y) * ((x < 0) ? -1 : 1);
			p.setX(Math.cos(newZAngle) * radius);
			p.setY(Math.sin(newZAngle) * radius);
		}
	}
	
	/**
	 * Rotates the object by <code>angle</code> in degrees on the Y axis.
	 * 
	 * @param angle
	 */
	public void rotateY(double angle) {
		//Updates yRotation variable.
		//yRotation += angle;
		//if(yRotation >= 360 || yRotation <= -360) yRotation = yRotation % 360;
		//if(yRotation == -0) yRotation = 0;
		//Rotates all points in the object.
		for(Point p : verticies) {
			double x = p.getX();
			double z = p.getZ();
			double newYAngle = Math.atan(x / z) + Math.toRadians(angle);
			double radius = Math.sqrt(z * z + x * x) * ((z < 0) ? -1 : 1);
			p.setX(Math.sin(newYAngle) * radius);
			p.setZ(Math.cos(newYAngle) * radius);
		}
	}
	
	/**
	 * Rotates the object by <code>angle</code> in degrees on the X axis.
	 * @param angle
	 */
	public void rotateX(double angle) {
		//Updates xRotation variable
		//xRotation += angle;
		//if(xRotation >= 360 || xRotation <= -360) xRotation = xRotation % 360;
		//if(xRotation == -0) xRotation = 0;
		//Rotates all points in the object.
		for(Point p : verticies) {
			double y = p.getY();
			double z = p.getZ();
			double newXAngle = Math.atan(z / y) + Math.toRadians(angle);
			double radius = Math.sqrt(y * y + z * z) * ((y < 0) ? -1 : 1);
			p.setY(Math.cos(newXAngle) * radius);
			p.setZ(Math.sin(newXAngle) * radius);
		}
	}
	
	/**
	 * Resets the x rotation back to 0.0.
	 */
	public void resetXRot() {
		rotateX(-getXRot());
		xRotation = 0.0;
	}
	
	/**
	 * Resets the x rotation to the value passed.
	 * @param value
	 */
	public void resetXRot(double angle) {
		resetXRot();
		rotateX(angle);
		xRotation = angle;
	}
	
	/**
	 * Returns the x rotation.
	 * @return
	 */
	public double getXRot() {
		return xRotation;
	}
	
	/**
	 * Resets the y rotation back to 0.0.
	 */
	public void resetYRot() {
		rotateY(-getYRot());
		yRotation = 0.0;
	}
	
	/**
	 * Resets the y rotation to the value passed.
	 * @param value
	 */
	public void resetYRot(double angle) {
		resetYRot();
		rotateY(angle);
		yRotation = angle;
	}
	
	/**
	 * Returns the y rotation.
	 * @return
	 */
	public double getYRot() {
		return yRotation;
	}
	
	/**
	 * Resets the z rotation back to 0.0.
	 */
	public void resetZRot() {
		rotateZ(-getZRot());
		zRotation = 0.0;
	}
	
	/**
	 * Resets the x rotation to the value passed.
	 * @param value
	 */
	public void resetZRot(double angle) {
		resetZRot();
		rotateZ(angle);
		zRotation = angle;
	}
	
	/**
	 * Returns the z rotation.
	 * @return
	 */
	public double getZRot() {
		return zRotation;
	}
	
	/**
	 * Sets zoom to the value passed. If the user wishes to add a value to scale, 
	 * they must first obtain the already set value for scale and pass the new value they wish to be the scale.
	 * @param value
	 */
	public void setZoom(double value) {
		zoom = value;
	}
	
	/**
	 * Returns the value of zoom.
	 * @return zoom value of the entity
	 */
	public double getZoom() {
		return zoom;
	}
	
	/**
	 * Resets the zoom value back to 1.0;
	 */
	public void resetZoom() {
		zoom = 1.0;
	}

	/**
	 * Returns all verticies for the 3D object.
	 * 
	 * @return
	 */
	public Point[] getVerticies(){
		return verticies;
	}
	
	/* UNUSED CODE
	public void renderTransformation(Graphics g) {
		g.setColor(Color.WHITE);
		//System.out.println(Math.toDegrees(getNetAngle(Math.sqrt(2.0) / 2.0, 1, 180.0)));
		for(Point p : verticies) {
			double x = p.getX();
			double y = p.getY();
			double z = p.getZ();
			
			double radiusToX = getRadius(y, z); //Math.sqrt(y * y + z * z) * ((y < 0) ? -1 : 1);
			double radiusToY = getRadius(x, z); //Math.sqrt(x * x + z * z) * ((z < 0) ? -1 : 1);
			double radiusToZ = getRadius(x, y); //Math.sqrt(x * x + y * y) * ((x < 0) ? -1 : 1);
			
			Point xAxis = new Point(x, 0, 0);
			Point yAxis = new Point(0, y, 0);
			Point zAxis = new Point(0, 0, z);
			
			
			
			//Z Rotation
			//double ySubRadius = Math.cos(Math.toRadians(zRotation));
			//double xSubRadius = Math.sin(Math.toRadians(zRotation));

			double zAngle = getNetAngle(x, radiusToZ, zRotation);//Math.toRadians(zRotation) + Math.atan(y / x);
			//double radius = Math.sqrt(x * x + y * y) * ((x < 0) ? -1 : 1);
			double newX = Math.cos(zAngle) * radiusToZ * (radiusToZ < 0 ? -1 : 1);
			//x = Math.cos(zAngle) * radiusToZ;
			double newY = Math.sin(zAngle) * radiusToZ * (radiusToZ < 0 ? -1 : 1);
			//y = Math.sin(zAngle) * radiusToZ;
			//double newZ = z;
			
			//Y Rotation
			yAxis.setX(yAxis.getX() * Math.cos(zRotation));
			yAxis.setY(yAxis.getY() * Math.sin(zRotation));
			System.out.println(yAxis.getX() + ", " + yAxis.getY() + ", " + yAxis.getZ());
			
			double yAngle = getNetAngle(z, radiusToY, yRotation);//Math.toRadians(yRotation) + Math.acos(z / radiusToY);
			newX = (Math.sin(yAngle) * (radiusToY) * (radiusToY < 0 ? -1 : 1)) + (Math.sin(zRotation) * y);// + newX;//Math.cos(zAngle) * radiusToY)) - newX;// * (z < 0 ? -1 : 1)); // angle * x distance to ObjectYAxis + objectYAxisDistToYAxis
			//		new coordinate relative to origin						origin offset			
			newY = (Math.sin(zAngle) * radiusToY) * (radiusToY < 0 ? -1 : 1);// + newY; // angle * y distance to y axis
			double newZ = Math.cos(yAngle) * (Math.sin(zAngle) * radiusToY);
			
			/*
			//double yAngle = Math.toRadians(yRotation) + Math.atan(x / z);
			double yAxisAnchorX = 0 - Math.sin(Math.toRadians(zRotation)) * y;
			double yAxisAnchorY = Math.cos(Math.toRadians(90 - zRotation)) * y;
			
			double xRadius = Math.cos(Math.toRadians(yRotation)) * radiusToY;
			double yRadius = Math.sin(Math.toRadians(yRotation)) * radiusToY;
			double yAngle = Math.toRadians(yRotation) + Math.atan((yAxisAnchorX - newX) / z);
			
			newX = Math.cos(yAngle) * xRadius + yAxisAnchorX;
			newY = Math.sin(yAngle) * yRadius + yAxisAnchorY;
			
			
			
			//radius = x;
			//x = Math.cos(angle) * radius;
			
			//radius = y;
			//y = Math.sin(angle + Math.toRadians(90)) * radius;
			
			int newXInt = (int) (newX + Canvas.worldX + xOffset);
			int newYInt = (int) (newY + Canvas.worldY + yOffset);
			g.drawLine(newXInt, newYInt, newXInt, newYInt);
		}
	}
	
	private double getRadius(double x, double y) {
		return Math.sqrt(x * x + y * y) * ( ( (x > 0 && y < 0) || (x < 0 && y > 0) ) ? -1 : 1);
	}
	
	private double getNetAngle(double adj, double hyp, double axisRotation) {
		double angle = Math.acos(adj / hyp);
		if(adj < 0 && hyp < 0)
			angle = Math.toRadians(180) - angle;
		else if(adj > 0 && hyp < 0)
			angle = Math.toRadians(360) - angle;
		else if(adj < 0 && hyp > 0)
			angle = Math.toRadians(180) + angle;
		angle += Math.toRadians(axisRotation);
		return angle;
	}
	*/
}
