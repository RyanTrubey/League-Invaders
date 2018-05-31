import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int menustate = 0;
	final int gamestate = 1;
	final int endstate = 2;
	int currentstate = menustate;
	Font titlefont;
	Font subfont;
	Font subfont2;
	Rocketship rocket;
	boolean KeyUp;
	boolean KeyDown;
	boolean KeyLeft;
	boolean KeyRight;
	boolean KeyW;
	ObjectManager om;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titlefont = new Font("Arial", Font.PLAIN, 48);
		subfont = new Font("Arial", Font.PLAIN, 35);
		subfont2 = new Font("Arial", Font.PLAIN, 27);
		rocket = new Rocketship(250, 700, 50, 50);
		om = new ObjectManager(rocket);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (!rocket.isAlive) {
			currentstate = endstate;
			rocket.isAlive = true;
		}
		
		if (currentstate == menustate) {
			updateMenuState();
		} else if (currentstate == gamestate) {
			updateGameState();
		} else if (currentstate == endstate) {
			updateEndState();
		}
		if (KeyUp && KeyLeft) {
			rocket.y -= rocket.speed;
			rocket.x -= rocket.speed;
		} else if (KeyUp && KeyRight) {
			rocket.y -= rocket.speed;
			rocket.x += rocket.speed;
		} else if (KeyDown && KeyLeft) {
			rocket.y += rocket.speed;
			rocket.x -= rocket.speed;
		} else if (KeyDown && KeyRight) {
			rocket.y += rocket.speed;
			rocket.x += rocket.speed;
		} else if (KeyUp) {
			rocket.y -= rocket.speed;
		} else if (KeyLeft) {
			rocket.x -= rocket.speed;
		} else if (KeyDown) {
			rocket.y += rocket.speed;
		} else if (KeyRight) {
			rocket.x += rocket.speed;
		}
		if (KeyW) {
			om.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
		}

		repaint();
	}

	public void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentstate == menustate) {
			drawMenuState(g);
		} else if (currentstate == gamestate) {
			drawGameState(g);
		} else if (currentstate == endstate) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentstate < endstate) {
				currentstate++;
			} else {
				currentstate = menustate;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_I) {
			if (currentstate == menustate) {
				JOptionPane.showMessageDialog(null, "Press 'space' to shoot and use arrow keys to move.");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			KeyUp = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			KeyDown = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			KeyLeft = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			KeyRight = true;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
		} else if(e.getKeyCode() == KeyEvent.VK_W) {
			KeyW=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			KeyUp = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			KeyDown = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			KeyLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			KeyRight = false;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			KeyW = false;
		}

	}

	public void updateMenuState() {
		currentstate = menustate;
		om.setScore(0);
	}

	public void updateGameState() {
		currentstate = gamestate;
		om.manageEnemies();
		om.checkColision();
		om.update();
		om.purgeObjects();
		if (rocket.isAlive == false) {
			currentstate = endstate;
			om.reset();
			rocket = new Rocketship(250, 700, 50, 50);
			om.addRocket(rocket);
		}
	}

	public void updateEndState() {
		currentstate = endstate;
	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titlefont);
		g.drawString("League Invaders", 65, 320);
		g.setFont(subfont);
		g.drawString("Press 'Enter' to start", 75, 420);
		g.setFont(subfont2);
		g.drawString("Press 'i' for instructions", 90, 490);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		om.draw(g);
		g.setColor(Color.WHITE);
		g.setFont(subfont2);
		g.drawString("Score: " + om.getScore().toString(), 30, 40);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titlefont);
		g.drawString("Game Over", 120, 400);
		g.setFont(subfont2);
		g.drawString("Score: " + om.getScore().toString(), 30, 40);
	}
}
