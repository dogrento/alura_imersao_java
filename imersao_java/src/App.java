import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! seu bosta");

        // fazer uma comunicação HTTP e buscar os top 250
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        ExtratorConteuto extrator = new ExtratorIMDB();

        var http = new ClientHTTP();
        String json = http.buscasDados(url);
      
        // System.out.println(response);
        // System.out.println(body);
        
        // ExtratorIMDB extrator = new ExtratorIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        // exibir e manipular os dados
        geradorSticker geradora = new geradorSticker();
        String dir = "saida/";

        for (int i=0 ; i<3 ; i++) {

            Conteudo conteudo = conteudos.get(i);

            String urlImage = conteudo.getUrlImagem();

            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo, dir);

            System.out.println(conteudo.getTitulo());
            // System.out.println(conteudo.get("imDbRating"));
        }
    }
}
