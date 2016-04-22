package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DopunskaProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblPitanje;
	private JTextField txtOdgovor;
	private JLabel lblOdgovor;
	private JLabel lblSkor;
	private JTextField txtSkor;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DopunskaProzor frame = new DopunskaProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DopunskaProzor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPitanje());
		contentPane.add(getTxtOdgovor());
		contentPane.add(getLblOdgovor());
		contentPane.add(getLblSkor());
		contentPane.add(getTxtSkor());
		contentPane.add(getBtnOk());
	}
	private JLabel getLblPitanje() {
		if (lblPitanje == null) {
			lblPitanje = new JLabel("Pitanje");
			lblPitanje.setHorizontalAlignment(SwingConstants.CENTER);
			lblPitanje.setBounds(24, 29, 394, 66);
		}
		return lblPitanje;
	}
	private JTextField getTxtOdgovor() {
		if (txtOdgovor == null) {
			txtOdgovor = new JTextField();
			txtOdgovor.setBounds(180, 138, 153, 20);
			txtOdgovor.setColumns(10);
		}
		return txtOdgovor;
	}
	private JLabel getLblOdgovor() {
		if (lblOdgovor == null) {
			lblOdgovor = new JLabel("Odgovor:");
			lblOdgovor.setBounds(85, 141, 55, 14);
		}
		return lblOdgovor;
	}
	private JLabel getLblSkor() {
		if (lblSkor == null) {
			lblSkor = new JLabel("SKOR");
			lblSkor.setBounds(119, 231, 46, 14);
		}
		return lblSkor;
	}
	private JTextField getTxtSkor() {
		if (txtSkor == null) {
			txtSkor = new JTextField();
			txtSkor.setEditable(false);
			txtSkor.setBounds(180, 228, 25, 20);
			txtSkor.setColumns(10);
		}
		return txtSkor;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setBounds(177, 180, 89, 23);
		}
		return btnOk;
	}
}
