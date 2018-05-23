import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	long moveTimer = 0;
	int alienMoveTime = 1000;

	public Alien(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void update() {
		super.update();
		y += 2;
		x += new Random().nextInt(15);
		x -= new Random().nextInt(15);
		if(x<=0) {
			x=LeagueInvaders.width;
		} else if(x>=LeagueInvaders.width) {
			x=0;
		}
		if (System.currentTimeMillis() - moveTimer >= alienMoveTime) {

			moveTimer = System.currentTimeMillis();
		}
		if (y > 800) {
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, w, h);
	}
}
