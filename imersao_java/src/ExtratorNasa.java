import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa implements ExtratorConteuto {
    public List<Conteudo> extraiConteudos(String json){
           // extrair os dados interessantes: title, poster, rating (parser os dados)
            var parser = new JsonParser();
            List <Map<String, String>> atributosList = parser.parse(json); 

            List<Conteudo> conteudos = new ArrayList<>(); 

            // popular a lista de conteudos        
            for (Map<String, String> atributos : atributosList){
                String titulo = atributos.get("title");
                String urlImagem = atributos.get("url");

                var conteudo = new Conteudo(titulo, urlImagem);

                conteudos.add(conteudo);
                
            }
            return conteudos;
    }
}
