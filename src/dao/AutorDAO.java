package dao;

import java.util.List;
import entidades.Autor;

public class AutorDAO {
	private Autor a = new Autor();

	public void cadastar(Autor a) {
		new DAO<Autor>(Autor.class).adicionar(a);
	}

	public Autor buscarPorId(int id) {
		a = new DAO<Autor>(Autor.class).buscaPorId(id);
		return a;
	}
	public Autor buscarPorNome(String nome) {
		a = new DAO<Autor>(Autor.class).buscaPorNome(nome);
		return a;
	}

	public void atualizar() {
		new DAO<Autor>(Autor.class).atualizar(this.a);
	}

	public void deletar(Autor a) {
		new DAO<Autor>(Autor.class).remover(a);
	}

	public List<Autor> listar() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
}