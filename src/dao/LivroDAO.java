package dao;

import entidades.Livro;

public class LivroDAO {
	private Livro l = new Livro();
	
	public Livro getLivro() {
		return l;
	}

	public void cadastar(Livro l) {
		new DAO<Livro>(Livro.class).adicionar(l);
	}
	
	public void buscar() {
		new DAO<Livro>(Livro.class).buscaPorId(this.l.getCod());
	}
	
	public void atualizar() {
		new DAO<Livro>(Livro.class).atualizar(this.l);
	}
	
	public void deletar() {
		new DAO<Livro>(Livro.class).remover(this.l);
	}
}