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
		if (y >= LeagueInvaders.height-h) {
			y=LeagueInvaders.height-h;
		}
	}

	public void draw(Graphics g) {
		 g.drawImage(GamePanel.rocketImg, x, y, w, h, null);
	}
}
