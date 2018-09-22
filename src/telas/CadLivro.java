package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.LivroDAO;
import entidades.Livro;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CadLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2522179588146196546L;
	Livro livro = new Livro();
	LivroDAO dao = new LivroDAO();
	Date data = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:MM");

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAno;
	private JTextArea textResenha;
	private JComboBox comboBoxAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadLivro frame = new CadLivro();
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
	public CadLivro() {
		setTitle("Cadastrar livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 52, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(52, 8, 345, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblResenha = new JLabel("Resenha:");
		lblResenha.setBounds(10, 64, 46, 14);
		contentPane.add(lblResenha);

		textResenha = new JTextArea();
		textResenha.setBounds(10, 89, 263, 153);
		contentPane.add(textResenha);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 36, 46, 14);
		contentPane.add(lblAno);

		textAno = new JTextField();
		textAno.setBounds(52, 36, 86, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(166, 36, 46, 14);
		contentPane.add(lblAutor);

		comboBoxAutor = new JComboBox();
		comboBoxAutor.setBounds(207, 36, 217, 20);
		contentPane.add(comboBoxAutor);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					livro.setNome(textNome.getText());
					livro.setAno(textAno.getText());
					livro.setResenha(textResenha.getText());
					livro.setData_cadastro(data);

					dao.cadastar(livro);
					JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
				}
		});
		btnGravar.setBounds(335, 237, 89, 23);
		contentPane.add(btnGravar);

		JLabel lblData = new JLabel("Data " + df.format(data));
		lblData.setBounds(10, 253, 263, 14);
		contentPane.add(lblData);
	}

}
