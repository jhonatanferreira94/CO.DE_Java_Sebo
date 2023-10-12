import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro extends Autor {
    public String titulo;
    public Autor autor;
    public float preco;
    public LocalDate dataLancamento;

    //Torna a lista privada
    private ArrayList<Livro> listaLivros = new ArrayList<>();

    //Metodo para tirar a lista main
    public void CadastroLivro(Livro livro){
        listaLivros.add(livro);
        System.out.println("Cadastro feito!");
    }

    //Para acessar a lista privada

    public ArrayList<Livro> ListarLivros (){
        return listaLivros;
    }
}
