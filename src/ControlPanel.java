import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {
JButton windowsize;
	public ControlPanel() {
	windowsize = new JButton("" + LeagueInvaders.width + " x " + LeagueInvaders.height);
	add(windowsize);
	setSize(LeagueInvaders.width, 100);
	windowsize.addActionListener(this);
	windowsize.setSelected(false);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
}
