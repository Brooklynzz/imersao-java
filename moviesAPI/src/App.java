import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão HTTP para requisitar os filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Parsear String
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir dados
        var stickers = new StickersGen();
        for (Map<String,String> filme: listaDeFilmes) {
            String urlImagem= filme.get("image");
            InputStream inputStream = new URL(urlImagem).openStream();

            System.out.println("Título: " + filme.get("title"));
            System.out.println();
            System.out.println("Classificação: " + filme.get("imDbRating"));
            System.out.println();
            stickers.cria(inputStream, filme.get("title"));
        }
    }
}
