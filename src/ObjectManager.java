import java.awt.Graphics;

public class ObjectManager {
Rocketship rocket;
public ObjectManager(Rocketship rocket) {
	this.rocket=rocket;
}
public void update() {
	rocket.update();
}
public void draw(Graphics g) {
	rocket.draw(g);
}
}
