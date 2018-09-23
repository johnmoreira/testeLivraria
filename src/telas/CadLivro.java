package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AutorDAO;
import dao.LivroDAO;
import entidades.Autor;
import entidades.Livro;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JScrollPane;

public class CadLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2522179588146196546L;
	Livro livro = new Livro();
	LivroDAO dao = new LivroDAO();
	AutorDAO aDao = new AutorDAO();
	Date data = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:MM");

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAno;
	private JTextArea textResenha;
	private JComboBox<String> comboBoxAutor;
	private JTextField textCodigo;

	ArrayList<Autor> lista = new ArrayList<>();

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
		setResizable(false);
		setTitle("Cadastrar livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(165, 64, 52, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(211, 61, 345, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblResenha = new JLabel("Resenha:");
		lblResenha.setBounds(10, 147, 111, 14);
		contentPane.add(lblResenha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 394, 168);
		contentPane.add(scrollPane);

		textResenha = new JTextArea();
		scrollPane.setViewportView(textResenha);
		textResenha.setTabSize(10);
		textResenha.setDropMode(DropMode.ON);
		textResenha.setLineWrap(true);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 102, 46, 14);
		contentPane.add(lblAno);

		textAno = new JTextField();
		textAno.setBounds(52, 99, 86, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(165, 102, 46, 14);
		contentPane.add(lblAutor);

		comboBoxAutor = new JComboBox<String>();
		comboBoxAutor.setBounds(211, 99, 217, 20);
		contentPane.add(comboBoxAutor);
		// popular combobox de autores
		lista.addAll(aDao.listar());
		for (int i = 0; i < lista.size(); i++) {
			comboBoxAutor.addItem(lista.get(i).getNome());
		}

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setNome(textNome.getText());
				livro.setAno(textAno.getText());
				livro.setResenha(textResenha.getText());
				livro.setData_cadastro(data);
				livro.setCod_autor(comboBoxAutor.getSelectedIndex());

				dao.cadastar(livro);
				JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
			}
		});
		btnGravar.setBounds(565, 376, 89, 23);
		contentPane.add(btnGravar);

		JLabel lblData = new JLabel("Data " + df.format(data));
		lblData.setBounds(10, 351, 263, 14);
		contentPane.add(lblData);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 376, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = (Integer.parseInt(textCodigo.getText()));
				livro = dao.buscar(i);
				textNome.setText(livro.getNome());
				textAno.setText(livro.getAno());
				textResenha.setText(livro.getResenha());
				comboBoxAutor.setSelectedIndex(livro.getCod_autor());
			}
		});

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 64, 59, 14);
		contentPane.add(lblCodigo);

		textCodigo = new JTextField();
		textCodigo.setBounds(52, 61, 86, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblCapa = new JLabel("Capa");
		lblCapa.setBounds(551, 147, 59, 14);
		contentPane.add(lblCapa);

		JLabel lblCadastroEBusca = new JLabel("CADASTRO E BUSCA DE LIVROS");
		lblCadastroEBusca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroEBusca.setBounds(23, 11, 465, 37);
		contentPane.add(lblCadastroEBusca);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(454, 376, 89, 23);
		contentPane.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigo.setText("");
				textNome.setText("");
				textAno.setText("");
				comboBoxAutor.setSelectedIndex(-1);
				textResenha.setText("");
			}
		});
	}
}
