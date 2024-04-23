package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme meuFilme = new Filme("Top Gun - Asas indomáveis", 1983);
        meuFilme.avalia(8);
        Filme outroFilme = new Filme("Rock IV", 2000);
        outroFilme.avalia(7);
        var filmesDoPaulo = new Filme("Onde os fracos não tem vez", 2000);
        filmesDoPaulo.avalia(9);

        Serie lost = new Serie("lost", 1995);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filmesDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo items : lista) {
            System.out.println(items.getNome());
            if (items instanceof  Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }
       List<String> buscarPorArtista = new ArrayList<>();
        buscarPorArtista.add("Xai");
        buscarPorArtista.add("Bruno");
        buscarPorArtista.add("Adam");
        buscarPorArtista.add("Carlos");


        System.out.println("Antes da ordenação " + buscarPorArtista);
        Collections.sort(buscarPorArtista);
        System.out.println("Depois da ordenação " + buscarPorArtista);


        System.out.println("Lista de titulos ordenados " );
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordemnando por ano: " + lista);
    }
}
