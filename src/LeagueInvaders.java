import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int width = 1920;
	final static int height = 1040;
	GamePanel gamepanel;

	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();
	}

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}

	public void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		gamepanel.startGame();
		frame.addKeyListener(gamepanel);
	}
}
