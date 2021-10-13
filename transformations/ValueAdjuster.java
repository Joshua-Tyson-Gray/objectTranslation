package transformations;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValueAdjuster extends JTextField{
	private JButton increment;
	private JButton decrement;
	//private JTextField textBox;
	private int width;
	private int height;
	private Canvas canvas;
	private double value;
	
	public ValueAdjuster(String val, JPanel controlPanel, Canvas canvas){
		super(val);
		
		this.canvas = canvas;
		this.value = 0.0;
		
		/*
		 * this.textBox = new JTextField(canvas.sphere.getXRot() + " degrees");
		 * textBox.setBackground(Color.LIGHT_GRAY); textBox.setBorder(null);
		 * textBox.setFocusable(false); controlPanel.add(this.textBox);
		 */
		
		this.increment = new JButton();
		increment.setBackground(Color.LIGHT_GRAY);
		increment.setText("+");
		increment.setBorder(null);
		increment.setFocusable(false);
		increment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//canvas.sphere.setXRot(5);
				//textBox.setText(canvas.sphere.getXRot() + " degrees");
				value += 5;
				setText(String.valueOf(value));
			}
		});
		controlPanel.add(increment);
		
		this.decrement = new JButton();
		decrement.setBackground(Color.LIGHT_GRAY);
		decrement.setText("-");
		decrement.setBorder(null);
		decrement.setFocusable(false);
		decrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//canvas.sphere.setXRot(-5);
				//textBox.setText(canvas.sphere.getXRot() + " degrees");
				value -= 5;
				setText(String.valueOf(value));
			}
		});
		controlPanel.add(decrement);
	}
	
	public void update() {
		value = Double.parseDouble(getText());
	}
	
	/**
	 * Returns the value of the component;
	 * @return
	 */
	public String getValue() {
		return this.getText();
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		if(height % 2 != 0) height++;
		super.setBounds(x, y, width, height);
		increment.setBounds(x + width, y, height / 2, height / 2);
		decrement.setBounds(x + width, y + height / 2, height / 2, height / 2);
		//this.setBounds(x, y, width, height);
	}
	
	
	/*
	 * @Override public void setBounds(int x, int y, int width, int height) {
	 * super.setBounds(getBounds()); increment.setBounds(increment.getX(),
	 * increment.getY(), this.getBounds().width - increment.getWidth(),
	 * this.getBounds().height - increment.getHeight());
	 * decrement.setBounds(decrement.getX(), decrement.getY(),
	 * this.getBounds().width - decrement.getWidth(), this.getBounds().height -
	 * decrement.getHeight()); }
	 */
}
