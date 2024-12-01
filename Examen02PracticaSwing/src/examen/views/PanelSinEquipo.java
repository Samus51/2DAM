package examen.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PanelSinEquipo extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelSinEquipo() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Actualmente no tienes equipo");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(PanelSinEquipo.class.getResource("/utils/ImgJugadorError.png")));
		add(lblNewLabel_1, BorderLayout.CENTER);

	}

}
