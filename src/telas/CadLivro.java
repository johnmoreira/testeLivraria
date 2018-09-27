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
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadLivro extends JFrame {

	private static final long serialVersionUID = -2522179588146196546L;
	private Livro livro;
	LivroDAO dao = new LivroDAO();
	AutorDAO aDao = new AutorDAO();
	Date data = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String caracteres = "0987654321";

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAno;
	private JTextArea textResenha;
	private JComboBox<Autor> comboBoxAutor;
	private JTextField textCodigo;
	private JButton btnAtualizar;

	ArrayList<Autor> lista = new ArrayList<>();

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

	public boolean campoVazio() {
		boolean vazio = true;
		if (textNome.getText().equals("") || textAno.getText().equals("") || textResenha.getText().equals("")
				|| comboBoxAutor.equals(-1)) {
			vazio = true;
		} else {
			vazio = false;
		}

		return vazio;
	}

	public CadLivro() {
		lista.addAll(aDao.listar());

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
		lblNome.setLabelFor(textNome);

		textNome = new JTextField();
		textNome.setBounds(211, 61, 345, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblResenha = new JLabel("Resenha:");
		lblResenha.setBounds(10, 147, 111, 14);
		contentPane.add(lblResenha);
		lblResenha.setLabelFor(textResenha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 394, 168);
		contentPane.add(scrollPane);

		textResenha = new JTextArea();
		scrollPane.setViewportView(textResenha);
		textResenha.setTabSize(10);
		textResenha.setLineWrap(true);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 102, 46, 14);
		contentPane.add(lblAno);
		lblAno.setLabelFor(textAno);

		textAno = new JTextField();
		textAno.setBounds(52, 99, 86, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);
		textAno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!caracteres.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
				if (textAno.getText().length() > 3) {
					evt.consume();
				}
			}
		});

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(165, 102, 46, 14);
		contentPane.add(lblAutor);
		lblAutor.setLabelFor(comboBoxAutor);
		comboBoxAutor = new JComboBox<Autor>();
		comboBoxAutor.setBounds(211, 99, 217, 20);
		contentPane.add(comboBoxAutor);
		// POPULAR COMBOBOX
		for (Autor a : lista)
			comboBoxAutor.addItem(a);

		// GRAVAR DADOS NO BANCO
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(10, 376, 89, 23);
		contentPane.add(btnGravar);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro = new Livro();
				livro.setCod(Integer.parseInt(textCodigo.getText()));
				livro.setNome(textNome.getText());
				livro.setAno(textAno.getText());
				livro.setResenha(textResenha.getText());
				livro.setData_cadastro(data);
				livro.setAutor(comboBoxAutor.getItemAt(comboBoxAutor.getSelectedIndex()));
				if (campoVazio()) {
					JOptionPane.showMessageDialog(null, "campo vazios!");
				} else {
					dao.cadastar(livro);
					JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
				}
			}
		});

		JLabel lblData = new JLabel("Data " + df.format(data));
		lblData.setBounds(10, 351, 263, 14);
		contentPane.add(lblData);

		// BUSCAR POR ID
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(109, 376, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro = new Livro();
				livro.setCod(Integer.parseInt(textCodigo.getText()));
				if (textCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "campo codigo vazio!");
				} else {
					if (dao.buscarPorId(livro.getCod()) == null) {
						JOptionPane.showMessageDialog(null, "Registro não existe!");
					}
					int i = (Integer.parseInt(textCodigo.getText()));
					livro = dao.buscarPorId(i);
					textNome.setText(livro.getNome());
					textAno.setText(livro.getAno());
					textResenha.setText(livro.getResenha());
					comboBoxAutor.getModel().setSelectedItem(livro.getAutor());
				}
			}
		});

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 64, 59, 14);
		contentPane.add(lblCodigo);
		lblCodigo.setLabelFor(textCodigo);

		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!caracteres.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
			}
		});
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

		// LIMPAR CAMPOS
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(551, 376, 89, 23);
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

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(315, 376, 89, 23);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro = new Livro();
				if (textCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "campo codigo vazio!");
				} else {
					livro.setCod(Integer.parseInt(textCodigo.getText()));
					dao.deletar(livro);
					JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
				}
			}
		});

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(211, 376, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setCod(Integer.parseInt(textCodigo.getText()));
				livro.setNome(textNome.getText());
				livro.setAno(textAno.getText());
				livro.setResenha(textResenha.getText());
				livro.setData_cadastro(data);
				livro.setAutor(comboBoxAutor.getItemAt(comboBoxAutor.getSelectedIndex()));

				if (campoVazio()) {
					JOptionPane.showMessageDialog(null, "Existem campos vazios!");
				} else {

					if (dao.buscarPorId(livro.getCod()) != null) {
						dao.atualizar(livro);
						JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Registro não existe!");
					}

				}
			}
		});

	}
}
