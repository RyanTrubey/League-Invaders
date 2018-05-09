import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	public Alien(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void update() {
		y++;
		if(y>800) {
			isAlive=false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, w, h);
	}
}
