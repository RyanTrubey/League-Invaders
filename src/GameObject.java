import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int w;
	int h;

	public GameObject(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void update() {
		x += 1;
		y += 2;
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}
