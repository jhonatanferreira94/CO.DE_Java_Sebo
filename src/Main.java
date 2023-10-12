import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Sebo Lestras e Jardim!");

        Livro metodoLivro = new Livro();

        Scanner leitor = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Escolha uma opção: 1. Cadastrar um livro / 2. Listar Obras / 0. Sair");
            opcao= leitor.nextLine();
            switch (opcao){
                case "1":

                    Livro novoLivro = new Livro();
                    novoLivro.autor = new Autor();

                    System.out.println("Data da lançamento: ");
                    novoLivro.dataLancamento= LocalDate.parse (leitor.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period idadeLivro = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (idadeLivro.getYears() >=5){
                        System.out.println("Livro aceito (;");
                    }else {
                        System.out.println("Livro não será aceito!");
                        break;
                    }

                    System.out.println("Digite o título: ");
                    novoLivro.titulo=leitor.next();

                    System.out.println("Nome do autor (a): ");
                    novoLivro.autor.nome=leitor.next();

                    System.out.println("Local de Nascimento: ");
                    novoLivro.autor.localNasc=leitor.next();

                    System.out.println("Valor: ");
                    novoLivro.preco=leitor.nextFloat();

                    metodoLivro.CadastroLivro(novoLivro);

                    break;
                case "2":
                    if (metodoLivro.ListarLivros().size()>0){
                        for (Livro cadaLivro : metodoLivro.ListarLivros()){
                            System.out.println("Título: "+cadaLivro.titulo);
                            System.out.println("Autor: "+cadaLivro.autor.nome);
                            System.out.println("Local de nascimento: "+cadaLivro.autor.localNasc);
                            System.out.println("Preço: "+cadaLivro.preco);
                            System.out.println("Data de lançamento: "+cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Idade do livro: "+ Period.between(cadaLivro.dataLancamento, LocalDate.now()).getYears());
                            System.out.println();
                            System.out.println("Aperte ENTER para continuar!");
                            leitor.nextLine();
                        }
                    }else {
                        System.out.println("Nenhum livro cadastrado.");
                    }
                    break;
                default:

                case "0":
                    System.out.println("Volte sempre!");
                    break;
            }
        }while (!opcao.equals("0"));
    }
}