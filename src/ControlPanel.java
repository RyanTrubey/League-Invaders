import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {
	JButton windowsize;
	JPanel panel;
	JFrame frame;

	public ControlPanel(JFrame frame, GamePanel gpanel) {
		windowsize = new JButton("" + LeagueInvaders.width + " x " + LeagueInvaders.height);
		add(windowsize);
		setSize(LeagueInvaders.width, 100);
		windowsize.addActionListener(this);
		windowsize.setSelected(false);
		this.frame = frame;
		panel = gpanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(LeagueInvaders.width == 1280) {
				panel.setPreferredSize(new Dimension(1920 , 1080));
			} else if (LeagueInvaders.width == 1920) {
				panel.setPreferredSize(new Dimension(2560, 1440));
			} else if (LeagueInvaders.width == 2560) {
				panel.setPreferredSize(new Dimension(3840, 2160));
			} else if (LeagueInvaders.width == 3840) {
				panel.setPreferredSize(new Dimension(1280, 720));
			}
			
			frame.pack();
		

	}
}
