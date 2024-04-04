import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroDeRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Main {

    public static void main(String[] args) {
        Filme meuFilme = new Filme();

        meuFilme.setNome("Top Gun - Asas indomáveis");
        meuFilme.setAnoDeLancamento(1983);
        meuFilme.setDuracaoEmMinutos(180);


        System.out.println(meuFilme.getNome());
        System.out.println(meuFilme.getAnoDeLancamento());
        System.out.println(meuFilme.getDuracaoEmMinutos());
        //System.out.println(meuFilme.incluidoNoPlano);

        meuFilme.exibirFichaTecnica();

        meuFilme.avalia( 10);
        meuFilme.avalia(5);
        meuFilme.avalia(2);
        System.out.println("A soma das avaliações é: " + meuFilme.getSomaDasAvalicacao());
        System.out.println("O total de avaliações são: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("A soma das avaliações é: " + meuFilme.getSomaDasAvalicacao());
        System.out.println("O total de avaliações são: " + meuFilme.getTotalDeAvaliacoes());

        System.out.println("A média de avaliações desse filme é: " +meuFilme.pegaMedia());

        Filme outroFilme = new Filme();

        outroFilme.setNome("Rock IV");
        outroFilme.setAnoDeLancamento(2000);
        outroFilme.setDuracaoEmMinutos(200);

        // calcular tempo total de filmes do catalogo.

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);



        System.out.println("Meus filmes possuem: " + calculadora.getTempoTotal());

        System.out.println("---------------------------------------------------------------------------------------");


        Serie lost = new Serie();

        lost.setNome("lost");
        lost.setAnoDeLancamento(1995);
        lost.exibirFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(82);
       System.out.println(" Duração para maratonar lost: " + lost.getDuracaoEmMinutos());

        calculadora.inclui(lost);

        System.out.println("Minhas diversões serão de " +   "" + ": " + calculadora.getTempoTotal());

        System.out.println("-----------------------------------------------------------------------------------");

        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme);

        System.out.println("-----------------------------------------------------------------------------------");

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);




    }
}
