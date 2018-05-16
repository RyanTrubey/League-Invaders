import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	long moveTimer = 0;
	int alienMoveTime = 100;

	public Alien(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void update() {
		super.update();
		y++;
		if (System.currentTimeMillis() - moveTimer >= alienMoveTime) {
			x+=new Random().nextInt(35);
			x-=new Random().nextInt(35);
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
