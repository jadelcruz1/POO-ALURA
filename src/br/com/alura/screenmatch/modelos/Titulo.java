package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;

    private double somaDasAvalicacao;
    private int totalDeAvaliacoes;
    @SerializedName("Runtime")
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb){
        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4){
            //throw  new ErroDeConversaoDeAnoException("Não conseguir converter o ano pois tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));

    }


    public double getSomaDasAvalicacao() {
        return somaDasAvalicacao;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibirFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano do filme: " + anoDeLancamento);
        System.out.println("Tempo estimado de apresentação: " + duracaoEmMinutos);
    }

    public void avalia(double nota){
        somaDasAvalicacao += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvalicacao / totalDeAvaliacoes;
    }


    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return  "nome: " + nome  +
                ", Ano De Lançamento: " + anoDeLancamento +
                ", duracão " + duracaoEmMinutos
               ;
    }
}
