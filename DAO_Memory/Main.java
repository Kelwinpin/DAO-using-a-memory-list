package DAO_Memory;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		var D = new DAO_Aluno();
		
		var aluno1 = new Aluno(12345990, "Eng. Computa��o", "15643290961", "Paulo Dias", LocalDate.of(2000, 12, 2));
		//Salvando aluno na m�moria
		D.save(aluno1);
		
		var aluno2 = new Aluno(167201821, "Direito", "00972813287", "Diana Prata", LocalDate.of(2001, 11, 23));
		D.save(aluno2);
		
		//Tentando salvar aluno com Id igual ao anterior
		var aluno = new Aluno(167201821, "Eng. Civil", "0097288182", "Roberto Pereira", LocalDate.of(2001, 11, 23));
		D.save(aluno);
		
		//Tentando salvar aluno com Id e CPF igual ao aluno2
		aluno = new Aluno(167201821, "Direito", "00972813287", "Alberto Pop", LocalDate.of(1996, 9, 29));
		D.save(aluno);
		
		//Tentando salvar aluno com CPF igual ao aluno2
		aluno = new Aluno(167201091, "Direito", "00972813287", "Dylan Borges", LocalDate.of(1999, 1, 2));
		D.save(aluno);
		
		aluno = new Aluno(12108925, "Farm�cia", "17900911277", "Doni Borges", LocalDate.of(1999, 1, 2));
		D.save(aluno);
		
		aluno = new Aluno(12345990, "ADS", "15643290961", "Paulo Dias", LocalDate.of(2000, 12, 2));
		D.save(aluno);
		
		System.out.println("");
		
		System.out.println(D.getAll()+"\n");
		
		//Deletando um aluno presente na m�moria.
		D.delete(aluno1);
		//Exibindo
		System.out.println(D.getAll()+"\n");
		//Deletando um aluno que n�o est� presente na m�moria
		aluno = new Aluno(167201091, "Direito", "00972813287", "Dylan Borges", LocalDate.of(1999, 1, 2));
		D.delete(aluno);
		System.out.println("\n");
		
		// Atualizando um aluno 
		var alunoAtualizado = new Aluno(12345990, "Arquitetura", "1576890012", "Carlos Luz", LocalDate.of(2004, 10, 22));
		D.update(alunoAtualizado);
		System.out.println(D.getAll()+"\n");
		
		//Tentando atualizar um aluno com Id inexistente
		alunoAtualizado = new Aluno(1, "Geografia", "15768795012", "L�o Silva", LocalDate.of(2000, 12, 2));
		D.update(alunoAtualizado);
	



	}

}
