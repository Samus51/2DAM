package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class RegistroBien extends JDialog {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Create the dialog.
	 */
	public RegistroBien() {
		
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 450, 527);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(0, 0, 205));
				panel.add(panel_1);
				{
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setForeground(new Color(255, 255, 255));
					panel_1.add(lblNewLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(135, 206, 250));
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(135, 206, 250));
			getContentPane().add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(135, 206, 250));
			getContentPane().add(panel, BorderLayout.EAST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(7, 2, 0, 0));
			{
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_8 = new JLabel("New label");
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_8);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("New label");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("New label");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_10 = new JLabel("New label");
				lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_10);
			}
			{
				JLabel lblNewLabel_9 = new JLabel("New label");
				lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_9);
			}
			{
				JLabel lblNewLabel_11 = new JLabel("New label");
				lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_11);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("New label");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_12 = new JLabel("New label");
				lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_12);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("New label");
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_7);
			}
			{
				JLabel lblNewLabel_13 = new JLabel("New label");
				lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_13);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_14 = new JLabel("New label");
				lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_14);
			}
		}
	}

}
