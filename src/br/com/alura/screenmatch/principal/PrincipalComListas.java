package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme meuFilme = new Filme("Top Gun - Asas indomáveis", 1983);
        meuFilme.avalia(8);
        Filme outroFilme = new Filme("Rock IV", 2000);
        outroFilme.avalia(7);
        var filmesDoPaulo = new Filme("onde os fracos não tem vez", 2000);
        filmesDoPaulo.avalia(9);

        Serie lost = new Serie("lost", 1995);

        ArrayList<Titulo> lista = new ArrayList<>();
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
    }
}
