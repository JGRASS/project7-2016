package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kviz.logika.TableModelDopunskaRang;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DopunskaHighscore extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnResetujRangListu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DopunskaHighscore frame = new DopunskaHighscore();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DopunskaHighscore() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DopunskaHighscore.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setEnabled(false);
		setTitle("RANG LISTA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTable(), BorderLayout.CENTER);
		contentPane.add(getBtnResetujRangListu(), BorderLayout.SOUTH);
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setEnabled(false);
			table.setModel(new TableModelDopunskaRang(GUIKontroler.vratiRangListu()) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		}
		return table;
	}
	private JButton getBtnResetujRangListu() {
		if (btnResetujRangListu == null) {
			btnResetujRangListu = new JButton("RESETUJ RANG LISTU");
			btnResetujRangListu.setIcon(new ImageIcon(DopunskaHighscore.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
			btnResetujRangListu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int opcija = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da resetujete rang listu?", "Paznja", JOptionPane.YES_NO_CANCEL_OPTION);
					if(opcija == JOptionPane.YES_OPTION){
						GUIKontroler.resetujRangListu();
						table.setModel(new TableModelDopunskaRang(GUIKontroler.vratiRangListu()));
					}
					
				}
			});
		}
		return btnResetujRangListu;
	}
}
