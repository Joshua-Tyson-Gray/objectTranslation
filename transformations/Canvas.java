package transformations;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JPanel;

/**
 * Represents a field in the GUI that will encapsulate the rendered world.
 * @author Gray
 *
 */
public class Canvas extends JPanel{
	public static double worldX;
	public static double worldY;
	public Entity entity;
	private Stack<Symbol> rotationHistory;
	
	public Canvas() {
		this.setOpaque(true);
		worldX = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
		worldY = (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - 125;
		entity = new UVSphere(10);
		rotationHistory = new Stack<Symbol>();
	}
	
	/**
	 * Represents a magnitude identified by a character. 
	 * In the context of the class Canvas, it is used to track an rotation event by recording 
	 * the degree of the rotation where the character is the capital letter corresponding to 
	 * the axis on which the rotation took place.
	 * @author Gray
	 *
	 */
	private class Symbol{
		public double value;
		public char type;
		
		public Symbol(double value, char type) {
			this.value = value;
			this.type = type;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		render(g);
		repaint();
	}
	
	/**
	 * Updates values based on InputEvents.
	 * @param e
	 */
	public void update(InputEvent e) {
		if(e instanceof KeyEvent) {
			switch( ((KeyEvent) e).getKeyCode()) {
			case KeyEvent.VK_W: 
				entity.yOffset -= 5;
				break;
			case KeyEvent.VK_S:
				entity.yOffset += 5;
				break;
			case KeyEvent.VK_A:
				entity.xOffset -= 5;
				break;
			case KeyEvent.VK_D:
				entity.xOffset += 5;
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
			}
		}else if(e instanceof MouseEvent){
			System.out.println("Mouse Event");
		}
	}
	
	/**
	 * Renders the world to the screen.
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		g.setColor(Color.GREEN);
		g.drawLine((int)Canvas.worldX, (int)Canvas.worldY - 1000, (int)Canvas.worldX, (int)Canvas.worldY + 1000);
		g.setColor(Color.RED);
		g.drawLine((int)Canvas.worldX - 1000, (int)Canvas.worldY, (int)Canvas.worldX + 1000, (int)Canvas.worldY);
		entity.render(g);
	}
	
	/**
	 * Rotates the entity on the z axis by <code>value</code> degrees.
	 * @param value
	 */
	public void rotZRot(double value) {
		if(!rotationHistory.empty() && rotationHistory.peek().type == 'Z') {
			rotationHistory.peek().value += value;
		}else {
			rotationHistory.push(new Symbol(value, 'Z'));
		}
		entity.resetZRot(entity.getZRot() + value);
	}
	
	/**
	 * Rotates the entity on the y axis by <code>value</code> degrees.
	 * @param value
	 */
	public void rotYRot(double value) {
		if(!rotationHistory.empty() && rotationHistory.peek().type == 'Y') {
			rotationHistory.peek().value += value;
		}else {
			rotationHistory.push(new Symbol(value, 'Y'));
		}
		entity.resetYRot(entity.getYRot() + value);
	}
	
	/**
	 * Rotates the entity on the x axis by <code>value</code> degrees.
	 * @param value
	 */
	public void rotXRot(double value) {
		if(!rotationHistory.empty() && rotationHistory.peek().type == 'X') {
			rotationHistory.peek().value += value;
		}else {
			rotationHistory.push(new Symbol(value, 'X'));
		}
		entity.resetXRot(entity.getXRot() + value);
	}
	
	/**
	 * Resets the entity's rotation.
	 */
	public void resetRotation() {
		while(!rotationHistory.empty()) {
			Symbol symbol = rotationHistory.pop();
			char type = symbol.type;
			double value = symbol.value;
			if(type == 'X') {
				entity.resetXRot(entity.getXRot() - value);
			}else if(type == 'Y') {
				entity.resetYRot(entity.getYRot() - value);
			}else if(type == 'Z') {
				entity.resetZRot(entity.getZRot() - value);
			}
		}
	}
}
