import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://api.nasa.gov/planetary/apod?api_key=hBt8ZxXs4ucVIkGpzYkpSOTPw1I4wvmYmZsPQLnC&start_date=2022-06-12&end_date=2022-06-14";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        // Conexão HTTP
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        //Conexão HTTP para requisitar o conteudo da nasa
        //ExtratorNasa extrator = new ExtratorNasa();
        //List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // Conexão HTTP para requisitar o conteudo do imdb
        ExtratorImdb extrator = new ExtratorImdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var stickers = new StickersGen();
        for (int i = 0; i < 3; i++) {
           Conteudo conteudo = conteudos.get(i);

           InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
           String nomeArquivo = conteudo.getTitulo() + ".png";

           stickers.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
