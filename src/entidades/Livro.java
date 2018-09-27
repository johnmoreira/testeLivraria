package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;

	private String nome;

	private String ano;

	private String resenha;

	private Date data_cadastro;

	@ManyToOne
	private Autor autor;

	private Byte[] imagem;

	// private List<Nota> nota;

	public Livro() {
	}

	public Livro(int cod, String nome, String ano, String resenha, Date data_cadastro, Autor autor, Byte[] imagem) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.ano = ano;
		this.resenha = resenha;
		this.data_cadastro = data_cadastro;
		this.autor = autor;
		this.imagem = imagem;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getResenha() {
		return resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Byte[] getImagem() {
		return imagem;
	}

	public void setImagem(Byte[] imagem) {
		this.imagem = imagem;
	}
}