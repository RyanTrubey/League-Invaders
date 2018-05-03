import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 10;
	}

	public void update() {
		y-=speed;
		if(y<0) {
		
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);
	}
}
