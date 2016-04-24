package kviz.gui.dijalog;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kviz.gui.GUIKontroler;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class LicitacijeScoreDijalog extends JDialog {
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblUpisiteVaseIme;
	private JTextField txtIme;
	private JLabel lblNaslovna;
	private JLabel lblRang;
	private boolean indikator;
	private int poeni;
	private JTextArea textAreaRangLista;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicitacijeScoreDijalog dialog = new LicitacijeScoreDijalog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setModal(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the dialog.
	 */
	public LicitacijeScoreDijalog(boolean button, int poeni) {
		setTitle("Rang lista");
		setBounds(100, 100, 522, 358);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnOk());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getLblUpisiteVaseIme());
		getContentPane().add(getTxtIme());
		getContentPane().add(getLblNaslovna());
		getContentPane().add(getLblRang());
		getContentPane().add(getTextAreaRangLista());
		setModal(true);
		setLocationRelativeTo(null);
		srediFormu(button, poeni);
	}
	
	private void srediFormu(boolean button, int poeni) {
		if(button == true){
			indikator = true;
			btnOk.setVisible(true);
			btnCancel.setVisible(false);
			lblNaslovna.setText("Broj poena koje ste osvojili je " + poeni+ ". Upisite svoje ime u odgovarajuce polje.");
			this.poeni = poeni;
		}else{
			indikator = false;
			btnOk.setVisible(false);
			btnCancel.setVisible(true);
			lblUpisiteVaseIme.setVisible(false);
			txtIme.setVisible(false);
			lblNaslovna.setText("Broj poena koje ste osvojili je " + poeni+ ". Niste uspeli da se upisete na rang listu");
			this.poeni = poeni;
		}
		textAreaRangLista.setText(GUIKontroler.rangListaLicitacije());
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ime = txtIme.getText().trim();
					if(ime.equals("")){
						JOptionPane.showMessageDialog(null, "Morate uneti ime.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
					}else{
						btnCancel.setVisible(true);
						btnOk.setVisible(false);
						GUIKontroler.upisiImeNaLicitacije(ime, poeni);
						textAreaRangLista.setText(GUIKontroler.rangListaLicitacije());
						try {
							GUIKontroler.serijalizujLicitacije();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Greska prilikom cuvanja rang liste.","Greska", 
															JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnOk.setBounds(327, 286, 80, 23);
		}
		return btnOk;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LicitacijeScoreDijalog.this.dispose();
				}
			});
			btnCancel.setBounds(416, 286, 80, 23);
		}
		return btnCancel;
	}
	private JLabel getLblUpisiteVaseIme() {
		if (lblUpisiteVaseIme == null) {
			lblUpisiteVaseIme = new JLabel("Upisite vase ime:");
			lblUpisiteVaseIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblUpisiteVaseIme.setBounds(31, 257, 99, 23);
		}
		return lblUpisiteVaseIme;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setBounds(140, 258, 113, 20);
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JLabel getLblNaslovna() {
		if (lblNaslovna == null) {
			lblNaslovna = new JLabel("Osvojili ste _____ poena. Upisite vase ime u odgovarajucem polju.");
			lblNaslovna.setBounds(31, 11, 452, 23);
		}
		return lblNaslovna;
	}
	private JLabel getLblRang() {
		if (lblRang == null) {
			lblRang = new JLabel("RANG LISTA");
			lblRang.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRang.setBounds(31, 45, 99, 23);
		}
		return lblRang;
	}
	private JTextArea getTextAreaRangLista() {
		if (textAreaRangLista == null) {
			textAreaRangLista = new JTextArea();
			textAreaRangLista.setEditable(false);
			textAreaRangLista.setBounds(31, 79, 376, 167);
		}
		return textAreaRangLista;
	}
}
