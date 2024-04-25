package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        try{
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o filme para busca: ");
        var busca =leitura.nextLine();
        String tituloCodificado = URLEncoder.encode(busca, "UTF-8");
        //String endereco = "https://www.omdbapi.com/?apikey=910a96b4&t=" + busca.replace(" ", " ");
            String endereco = "https://www.omdbapi.com/?apikey=910a96b4&t=" + tituloCodificado;

            HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        String json = response.body();
        System.out.println(json);

        //Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

            // Titulo meuTitulo1 = gson.fromJson(json, Ti tulo.class);
            //TituloOmdb meuTitulo = gson.fromJson(json, TituloOmdb.class);


       // try {
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            //System.out.println(meuTituloOmdb);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);

            // criação de arquivo
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();


        } catch (IllegalArgumentException e) {
            System.out.println(("Algum erro de argumento na execução da busca, verifique o titulo. "));
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());

        }

        finally {
            System.out.println("O programa finalizou corretamente.");
        }

        try {

        File arquivo = new File("filmes.txt");
        Scanner scanner = new Scanner(arquivo);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            System.out.println("Conteudo do arquivo: " + linha);
        }

        scanner.close();
    } catch ( FileNotFoundException e) {
        System.out.println("Arquivo não encontrado!" + e.getMessage());
    } }

}
