import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	public Rocketship(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, w, h);
	}
}
