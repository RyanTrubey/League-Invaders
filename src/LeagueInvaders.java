import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	static int width = 1920;
	static int height = 1080;
	GamePanel gamepanel;
	ControlPanel controls;
	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();
	}

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
		controls = new ControlPanel();
	}

	public void setup() {
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.add(gamepanel, BorderLayout.CENTER);
		frame.add(controls, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		gamepanel.setSize(width, height-100);
		frame.pack();
		gamepanel.startGame();
		frame.addKeyListener(gamepanel);
		gamepanel.setFocusable(true);
	}
}
