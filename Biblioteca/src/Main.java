import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void cadastrarAluno(List<Aluno> alunos, Scanner tec) {
		Aluno aluno = new Aluno();
		System.out.println("informe o nome do aluno");
		aluno.nome = tec.nextLine();
		System.out.println("Digite a idade do aluno");
		aluno.idade = tec.nextInt();
		System.out.println("Informe o CPF do aluno");
		aluno.cpf = tec.nextInt();
		System.out.println("Informe o ra do aluno");
		aluno.ra = tec.nextInt();
		tec.nextLine();
		alunos.add(aluno);

	}
	
	public static void deletarAluno(List<Aluno> alunos, String nome) {
		for(int i = 0; i < alunos.size(); i++) {
			Aluno alunoAtual = alunos.get(i);
			if(alunoAtual.nome.equalsIgnoreCase(nome)) {
				alunos.remove(i);
				System.out.println("Aluno " + nome + " removido com sucesso!");
			}
			System.out.println("Aluno " + nome + " não encontrado!");
		}
	}
	
	public static void alterarAluno(List<Aluno> alunos, String nome, Scanner tec) {
		for(int i = 0; i < alunos.size(); i++){
			Aluno alunoAtual = alunos.get(i);
			if(alunoAtual.nome.equalsIgnoreCase(nome)) {
				System.out.println("Aluno " + nome + " encontrado! Preencha com os novos dados \n");
				System.out.print("Primeiro nome: ");
				alunoAtual.nome = tec.nextLine();
				System.out.print("RA: ");
				alunoAtual.ra = tec.nextInt();
				System.out.print("CPF:");
				alunoAtual.cpf = tec.nextInt();
				System.out.println("Idade: ");
				alunoAtual.idade = tec.nextInt();
				System.out.println("Dados do aluno alterados com sucesso!");
			}
			
			System.out.println("Aluno não encontrado");
			
		}
	}
	
	public static void cadastrarLivro(List<Livro> livros, Scanner tec) {
		Livro livro = new Livro();
		System.out.println("Digite o nome do livro");
		livro.nome = tec.nextLine();
		System.out.println("Digite o nome do autor");
		livro.autor = tec.nextLine();
		System.out.println("Digite o nome da editora");
		livro.editora = tec.nextLine();
		System.out.println("Digite o ano de publicação");
		livro.ano = tec.nextInt();
		livros.add(livro);
	}
	
	public static void deletarLivro(List<Livro> livros, String nome) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livroAtual = livros.get(i);
			if(livroAtual.nome.equalsIgnoreCase(nome)) {
				livros.remove(i);
				System.out.println("Livro " + nome + " removido com sucesso!");
			}
			System.out.println("Livro " + nome + " não encontrado!");
		}
	}
	
	public static void alterarLivro(List<Livro> livros, String nome, Scanner tec) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livroAtual = livros.get(i);
			if(livroAtual.nome.equalsIgnoreCase(nome)) {
				System.out.println("Livro " + nome + " encontrado! Preencha com os novos dados \n");
				System.out.print("Novo nome: ");
				livroAtual.nome = tec.nextLine();
				System.out.print("Autor: ");
				livroAtual.autor = tec.nextLine();
				System.out.print("Editora: ");
				livroAtual.editora = tec.nextLine();
				System.out.println("Ano: ");
				livroAtual.ano= tec.nextInt();
				System.out.println("Dados do livro alterados com sucesso!");
			}
			
			System.out.println("Livro não encontrado");
		}
	}
	
	public static void emprestar(List<Livro> livros, List<Aluno> alunos, List<Emprestar> emprestimos, Scanner tec) {
		String nomeLivroProcurado = "";
		String nomeAlunoProcurado = "";
		Aluno alunoEncontrado = null;
		Livro livroEncontrado = null;
		
		System.out.println("Digite o nome do aluno que o livro será emprestado");
		nomeAlunoProcurado = tec.nextLine();
		for(Aluno aluno : alunos) {
			if(aluno.nome.equalsIgnoreCase(nomeAlunoProcurado)) {
				System.out.println("O aluno existe");
				alunoEncontrado = aluno;
				break;
			}
		}
		
		if(alunoEncontrado ==  null) {
			System.out.println("O aluno não existe");
			return;
		}
		
		System.out.println("Digite o nome do livro que será emprestado");
		nomeLivroProcurado = tec.nextLine();
		for(Livro livro : livros) {
			if(livro.nome.equalsIgnoreCase(nomeAlunoProcurado)) {
				System.out.println("Livro encontrado");
				livroEncontrado = livro;
			}
		}
		
		if(livroEncontrado == null) {
			System.out.println("Livro não encontrado");
			return;
		}
		
		
		Emprestar novoEmprestimo = new Emprestar();
		novoEmprestimo.aluno = alunoEncontrado;
		novoEmprestimo.livro = livroEncontrado;
		emprestimos.add(novoEmprestimo);
		
		livros.remove(livroEncontrado);
		
		System.out.println("Livro " + nomeLivroProcurado + " emprestado ao aluno " + nomeAlunoProcurado + " com sucesso.");
	}
	
	public static void devolucao(List<Livro> livros, List<Emprestar> emprestimos, String nome) {
		Emprestar emprestimoParaRemover = null;
		Livro livroParaDevolver = null;
		for(Emprestar emprestimo : emprestimos) {
			if(emprestimo.livro.nome.equalsIgnoreCase(nome)) {
				livros.add(livroParaDevolver);
				emprestimos.remove(emprestimoParaRemover);
				System.out.println("O livro " + nome + " foi devolvido com sucesso!");
			}
		}
		
		System.out.println("O livro " + nome + " não foi encontrado na lista de Emprestimos");
	}
	
	public static void visualizarEmprestimos(List<Emprestar> emprestimos) {
		if(emprestimos.isEmpty()) {
			System.out.println("Nenhum livro emprestado encontrado");
		} else {
			System.out.println("Lista dos livros emprestados");
			for(Emprestar emprestimo : emprestimos) {
				System.out.println("Nome: " + emprestimo.livro.nome + ", Autor: " + emprestimo.livro.autor + ", Editora: " + emprestimo.livro.editora + ", Ano de Publiação: " + emprestimo.livro.ano);
			}
		}
	}
	
	public static void visualizarLivros(List<Livro> livros) {
		if(livros.isEmpty()) {
			System.out.println("Nenhum livro encontrado");
		} else {
			System.out.println("Lista dos livros");
			for(Livro livro: livros) {
				System.out.println("Nome: " + livro.nome + ", Autor: " + livro.autor + ", Editora: " + livro.editora + ", Ano de Publiação: " + livro.ano);
			}
		}
	}
	
	public static void visualizarAlunos(List<Aluno> alunos) {
		if(alunos.isEmpty()) {
			System.out.println("Nenhum aluno encontrado");
		} else {
			System.out.println("Lista dos alunos");
			for(Aluno aluno : alunos) {
				System.out.println("Nome: " + aluno.nome + ", RA: " + aluno.ra + ", CPF: " + aluno.cpf + ", idade: " + aluno.idade);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		List<Aluno> alunos = new LinkedList<>();
		List<Livro> livros = new LinkedList<>();
		List<Emprestar> emprestimos = new LinkedList<>();
		String nomeAlunoRemover;
		String nomeAlunoAlterar;
		String nomeLivroRemover;
		String nomeLivroAlterar;
		String nomeLivroDevolver;
		int option = 1;
	    while(option != 12) {
	    	System.out.println("\n--- Bem-vindo à Biblioteca ---");
	        System.out.println("1: Cadastrar aluno");
	        System.out.println("2: Deletar aluno");
	        System.out.println("3: Alterar aluno");
	        System.out.println("4: Visualizar alunos");
	        System.out.println("5: Cadastrar um livro");
	        System.out.println("6: Deletar livro");
	        System.out.println("7: Alterar livro");
	        System.out.println("8: Visualizar livros");
	        System.out.println("9: Emprestar livro para aluno");
	        System.out.println("10: Fazer devolução de livro");
	        System.out.println("11: Visualizar empréstimos");
	        System.out.println("12: SAIR");
		    option = tec.nextInt();
		    tec.nextLine();
	        switch(option) {
	        case 1:
	        	cadastrarAluno(alunos, tec);
	        	break;
	        case 2:
	        	System.out.println("Digite o nome do aluno a ser removido");
	        	nomeAlunoRemover = tec.nextLine();
	        	deletarAluno(alunos, nomeAlunoRemover);
	        	break;
	        case 3:
	        	System.out.println("Digite o nome do aluno a ser alterado");
	        	nomeAlunoAlterar = tec.nextLine();
	        	alterarAluno(alunos, nomeAlunoAlterar, tec);
	        	break;
	        case 4:
	        	visualizarAlunos(alunos);
	        	break;
	        case 5:
	        	cadastrarLivro(livros, tec);
	        	break;
	        case 6:
	        	System.out.println("Digite o nome do livro a ser removido");
	        	nomeLivroRemover = tec.nextLine();
	        	deletarLivro(livros, nomeLivroRemover);
	        	break;
	        case 7:
	        	System.out.println("Digite o nome do livro a ser alterado");
	        	nomeLivroAlterar = tec.nextLine();
	        	alterarLivro(livros, nomeLivroAlterar, tec);
	        	break;
	        case 8:
	        	visualizarLivros(livros);
	        	break;
	        case 9:
	        	emprestar(livros, alunos, emprestimos, tec);
	        	break;
	        case 10:
	        	System.out.println("Digite o nome do livro a ser devolvido");
	        	nomeLivroDevolver = tec.nextLine();
	        	devolucao(livros, emprestimos, nomeLivroDevolver);
	        	break;
	        case 11:
	        	visualizarEmprestimos(emprestimos);
	        	break;
	        case 12:
	        	break;
	        default:
	        	System.out.println("Opção inválida");
	        	break;
	        }
	    }
        
	}

}
