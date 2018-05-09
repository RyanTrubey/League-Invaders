import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 500;
Rocketship rocket;
ArrayList<Projectile> pList = new ArrayList<Projectile>();
ArrayList<Alien> aList = new ArrayList<Alien>();
public ObjectManager(Rocketship rocket) {
	this.rocket=rocket;
}
public void update() {
	rocket.update();
	for(Projectile p: pList) {
		p.update();
	}
	for(Alien a: aList) {
		a.update();
	}
}
public void draw(Graphics g) {
	rocket.draw(g);
	for(Projectile p: pList) {
		p.draw(g);
	}
	for(Alien a: aList) {
		a.draw(g);
	}
}
public void addProjectile(Projectile p) {
	pList.add(p);
}
public void addAlien(Alien a) {
	aList.add(a);
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}
public void purgeObjects() {
	
}
}

