package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	private String nome;
	private String ano;
	private String resenha;
	private Date data_cadastro;
	private int cod_autor;
	//private int cod_nota;

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

	public int getCod_autor() {
		return cod_autor;
	}

	public void setCod_autor(int cod_autor) {
		this.cod_autor = cod_autor;
	}

/*	public int getCod_nota() {
		return cod_nota;
	}

	public void setCod_nota(int cod_nota) {
		this.cod_nota = cod_nota;
	} */
}