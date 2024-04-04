package br.com.alura.screenmatch.modelos;

public class Titulo {

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;

    private double somaDasAvalicacao;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

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
}
