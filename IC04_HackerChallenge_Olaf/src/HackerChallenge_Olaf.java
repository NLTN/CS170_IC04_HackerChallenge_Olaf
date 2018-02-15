
/*
    Nguyen, Nguyen
    CS A170
    02/12/2018

    IC04_HackerChallenge_Olaf
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class HackerChallenge_Olaf extends JApplet {
	private static final long serialVersionUID = 1L;

	// Fields
	private final int CANVAS_WIDTH = 250, CANVAS_HEIGHT = 500;

	// Initialize
	public void init() {
		// Set the canvas size.
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
	}

	// Paint
	public void paint(Graphics canvas) {
		// Clear the canvas
		canvas.clearRect(0, 0, this.getWidth(), this.getHeight());

		try {
			// Reading/Loading the Image from resource
			// https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
			BufferedImage img = ImageIO.read(this.getClass().getResource("/resources/Olaf.png"));
			for (int i = 0; i < img.getWidth(); i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					// Set color
					if (img.getRGB(i, j) >= 0) { // Transparent
						canvas.setColor(Color.white);
					} else {
						canvas.setColor(new Color(img.getRGB(i, j)));
					}

					// Draw
					canvas.drawRect(i, j, 1, 1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}