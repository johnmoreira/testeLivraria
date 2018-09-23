package dao;

import java.util.List;

import entidades.Autor;

public class AutorDAO {
	private Autor a = new Autor();
	public void cadastar(Autor a) {
		new DAO<Autor>(Autor.class).adicionar(a);
	}
	
	public Autor buscar(int i) {
		a = new DAO<Autor>(Autor.class).buscaPorId(i);
		return a;
	}
	
	public void atualizar() {
		new DAO<Autor>(Autor.class).atualizar(this.a);
	}
	
	public void deletar() {
		new DAO<Autor>(Autor.class).remover(this.a);
	}
	
	public List<Autor> listar() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
}