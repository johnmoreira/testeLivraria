package dao;

import java.util.List;
import entidades.Livro;

public class LivroDAO {
	private Livro l = new Livro();

	public void cadastar(Livro l) {
		new DAO<Livro>(Livro.class).adicionar(l);
	}

	public Livro buscarPorId(int id) {
		l = new DAO<Livro>(Livro.class).buscaPorId(id);
		return l;
	}

	public Livro buscarPorNome(String nome) {
		l = new DAO<Livro>(Livro.class).buscaPorNome(nome);
		return l;
	}

	public void atualizar(Livro l) {
		new DAO<Livro>(Livro.class).atualizar(l);
	}

	public void deletar(Livro l) {
		new DAO<Livro>(Livro.class).remover(l);
	}

	public List<Livro> listar() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}
}