import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	static int width = 1280;
	static int height = 720;
	GamePanel gamepanel;
	ControlPanel controls;
	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();
	}

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
		controls = new ControlPanel(frame, gamepanel);
	}

	public void setup() {
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.setPreferredSize(new Dimension (width, height-100));
		frame.add(controls, BorderLayout.CENTER);
		frame.add(gamepanel, BorderLayout.NORTH);
		frame.pack();
		gamepanel.startGame();
		frame.addKeyListener(gamepanel);
	//	gamepanel.setFocusable(true);
	}
}
