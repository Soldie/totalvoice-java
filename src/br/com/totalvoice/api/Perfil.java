package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.Request;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;
import java.io.IOException;

public class Perfil {

    public static final String ROTA_CONTA   = "conta";
    public static final String ROTA_WEBHOOK = "webhook";
    public static final String ROTA_SALDO   = "saldo";

    private ClientInterface client;
    private RequestInterface request;

    public Perfil(ClientInterface client) {
        this.client = client;
        this.request = new Request();        
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws IOException
     */
    public JSONObject consultaSaldo() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_SALDO);
        request.setPath(path);

        return client.get(request);
    }

    /**
     * Consulta os dados da Minha Conta
     * @return
     * @throws IOException
     */
    public JSONObject minhaConta() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        request.setPath(path);

        return client.get(request);
    }

    /**
     * Atualiza os dados da Minha
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject atualizaDadosConta(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws IOException
     */
    public JSONObject relatorioRecarga() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("recargas");
        request.setPath(path);

        return client.get(request);
    }
    
    /**
     * Gera uma URL para recarga de créditos
     * @return
     * @throws IOException
     */
    public JSONObject urlRecarga(String urlRetorno) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("urlrecarga");
        
        QueryString query = new QueryString();
        query.add("url_retorno", urlRetorno);
        
        request.setPath(path);
        request.setQuery(query);        

        return client.get(request);
    }
    
    /**
     * Retorna a lista de webhooks configurados para esta conta
     * @return
     * @throws IOException
     */
    public JSONObject webhooks() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_WEBHOOK);
                
        request.setPath(path);     

        return client.get(request);
    }
}
