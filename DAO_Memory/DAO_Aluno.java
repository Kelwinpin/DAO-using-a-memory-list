package DAO_Memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAO_Aluno implements DAO<Aluno> {
	private List<Aluno> alunos = new ArrayList<Aluno>();


	@Override
	public Optional<Aluno> get(long id) {
		for(Aluno a : alunos) {
			if(a.getId() == id) {
				return Optional.of(a);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Aluno> getAll() {
		// TODO Auto-generated method stub
		System.out.println("Exibindo alunos ...");
		return alunos;
	}

	@Override
	public void save(Aluno t) {
		// TODO Auto-generated method stub
		boolean cad = false;
 		for(Aluno a : alunos) {	
 	     if(t.getId().equals(a.getId()) && t.getCpf().equals(a.getCpf()) && !t.getNome().equals(a.getNome())) {
		   System.out.println("CPF e ID já cadastrado !!!");
		   cad = true;
		   break;
		}else if(t.getId().equals(a.getId()) && !t.getNome().equals(a.getNome())){
			System.out.println("ID já cadastrado !!!");
			cad = true;
			break;
		}else if(t.getCpf().equals(a.getCpf()) && !t.getNome().equals(a.getNome())) {
		   System.out.println("CPF já cadastrado !!!");
		   cad = true;
		   break;
		}
	}
 		if(!cad) {
 			this.alunos.add(t);
 			System.out.println("Aluno salvo com sucesso !!!");
 	 		}
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		var exist = get(t.getId());
		if(exist.isPresent()) {
			var at = exist.get();
			at.setNome(t.getNome());
			at.setMatricula(t.getMatricula());
			at.setCpf(t.getCpf());
			System.out.println("Aluno encontrado e atualizado com sucesso !!!");
		}else {
			System.out.println("Aluno não encontrado !!!");
		}
	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		var exist = get(t.getId());
		if(exist.isPresent()) {
		alunos.remove(t);	
		System.out.println("Remoção concluída !!!");
	  }else {
		  System.out.println("Aluno não encontrado !!!");
	  }
	}

}
