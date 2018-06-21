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
		if(x<=10) {
			x+=25;
		} else if(x>=LeagueInvaders.width-10) {
			x-=25;
		}
		if (System.currentTimeMillis() - moveTimer >= alienMoveTime) {

			moveTimer = System.currentTimeMillis();
		}
		if (y > LeagueInvaders.height) {
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, w, h, null);
	}
}
