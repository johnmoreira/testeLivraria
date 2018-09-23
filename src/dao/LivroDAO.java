package dao;

import entidades.Livro;

public class LivroDAO {
	private Livro l = new Livro();

	public void cadastar(Livro l) {
		new DAO<Livro>(Livro.class).adicionar(l);
	}
	
	public Livro buscar(int i) {
		l =new DAO<Livro>(Livro.class).buscaPorId(i);
		return l;
	}
	
	public void atualizar() {
		new DAO<Livro>(Livro.class).atualizar(this.l);
	}
	
	public void deletar() {
		new DAO<Livro>(Livro.class).remover(this.l);
	}
	
	public void listar() {
		new DAO<Livro>(Livro.class).listaTodos();
	}
}