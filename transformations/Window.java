package transformations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements KeyListener{

	private JPanel contentPane;
	private Canvas canvas;
	private JPanel controlPanel;
	
	public Window() {
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1100, 900));
		//contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		canvas = new Canvas();
		canvas.setFocusable(true);
		canvas.addKeyListener(this);
		contentPane.add(canvas);
		
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.GRAY);
		controlPanel.setPreferredSize(new Dimension(10, 230));
		controlPanel.setLayout(null);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		
		JButton btnRotX = new JButton();
		btnRotX.setBounds(10, 10, 200, 100);
		btnRotX.setBackground(Color.LIGHT_GRAY);
		btnRotX.setText("ROTATE X +");
		btnRotX.setBorder(null);
		btnRotX.setFocusable(false);
		btnRotX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.rotXRot(1);
			}
		});
		controlPanel.add(btnRotX);
		
		JButton btnRotY = new JButton();
		btnRotY.setBounds(10, 120, 200, 100);
		btnRotY.setBackground(Color.LIGHT_GRAY);
		btnRotY.setText("ROTATE Y +");
		btnRotY.setBorder(null);
		btnRotY.setFocusable(false);
		btnRotY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.rotYRot(1);
			}
		});
		controlPanel.add(btnRotY);
		
		JButton btnRotZ = new JButton();
		btnRotZ.setBounds(220, 120, 200, 100);
		btnRotZ.setBackground(Color.LIGHT_GRAY);
		btnRotZ.setText("ROTATE Z +");
		btnRotZ.setBorder(null);
		btnRotZ.setFocusable(false);
		btnRotZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.rotZRot(1);
			}
		});
		controlPanel.add(btnRotZ);
		
		JButton btnRotReset = new JButton();
		btnRotReset.setBounds(220, 10, 200, 100);
		btnRotReset.setBackground(Color.LIGHT_GRAY);
		btnRotReset.setText("RESET ROTATION");
		btnRotReset.setBorder(null);
		btnRotReset.setFocusable(false);
		btnRotReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.resetRotation();			}
		});
		controlPanel.add(btnRotReset);
		
		JButton btnUp = new JButton();
		btnUp.setBounds(650, 10, 200, 100);
		btnUp.setBackground(Color.LIGHT_GRAY);
		btnUp.setText("UP");
		btnUp.setBorder(null);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.yOffset -= 5;
			}
		});
		controlPanel.add(btnUp);
		
		JButton btnDown = new JButton();
		btnDown.setBounds(650, 120, 200, 100);
		btnDown.setBackground(Color.LIGHT_GRAY);
		btnDown.setText("DOWN");
		btnDown.setBorder(null);
		btnDown.setFocusable(false);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.yOffset += 5;
			}
		});
		controlPanel.add(btnDown);
		
		JButton btnLeft = new JButton();
		btnLeft.setBounds(440, 65, 200, 100);
		btnLeft.setBackground(Color.LIGHT_GRAY);
		btnLeft.setText("LEFT");
		btnLeft.setBorder(null);
		btnLeft.setFocusable(false);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.xOffset -= 5;
			}
		});
		controlPanel.add(btnLeft);
		
		JButton btnRight = new JButton();
		btnRight.setBounds(860, 65, 200, 100);
		btnRight.setBackground(Color.LIGHT_GRAY);
		btnRight.setText("RIGHT");
		btnRight.setBorder(null);
		btnRight.setFocusable(false);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.xOffset += 5;
			}
		});
		controlPanel.add(btnRight);
		
		JButton btnOffsetReset = new JButton();
		btnOffsetReset.setBounds(1070, 65, 200, 100);
		btnOffsetReset.setBackground(Color.LIGHT_GRAY);
		btnOffsetReset.setText("RESET TRANSLATION");
		btnOffsetReset.setBorder(null);
		btnOffsetReset.setFocusable(false);
		btnOffsetReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.yOffset = 0;
				canvas.entity.xOffset = 0;
			}
		});
		controlPanel.add(btnOffsetReset);

		JButton btnMax = new JButton();
		btnMax.setBounds(1290, 10, 200, 100);
		btnMax.setBackground(Color.LIGHT_GRAY);
		btnMax.setText("ZOOM IN");
		btnMax.setBorder(null);
		btnMax.setFocusable(false);
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.setZoom(canvas.entity.getZoom() + 0.1);
			}
		});
		controlPanel.add(btnMax);
		
		JButton btnMin = new JButton();
		btnMin.setBounds(1290, 120, 200, 100);
		btnMin.setBackground(Color.LIGHT_GRAY);
		btnMin.setText("ZOOM OUT");
		btnMin.setBorder(null);
		btnMin.setFocusable(false);
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.setZoom(canvas.entity.getZoom() - 0.1);
			}
		});
		controlPanel.add(btnMin);
		
		JButton btnZoomReset = new JButton();
		btnZoomReset.setBounds(1500, 65, 200, 100);
		btnZoomReset.setBackground(Color.LIGHT_GRAY);
		btnZoomReset.setText("RESET ZOOM");
		btnZoomReset.setBorder(null);
		btnZoomReset.setFocusable(false);
		btnZoomReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.entity.resetZoom();
			}
		});
		controlPanel.add(btnZoomReset);
		
		this.add(contentPane);
		this.setSize(1000, 800);
		this.setMinimumSize(new Dimension(300, 300));
		this.setTitle("Test");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		canvas.update(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	//===============================TESTING====================================================
	public static void main(String[] args) {
		new Window();
	}
}
