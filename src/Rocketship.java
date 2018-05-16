import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	public Rocketship(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed=5;
	}

	public void update() {
		super.update();
		if(x>LeagueInvaders.width) {
			x=0;
		}
		if(x<0) {
			x=LeagueInvaders.width;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, w, h);
	}
}
