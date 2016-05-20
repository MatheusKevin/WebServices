package app;

import javax.xml.ws.Endpoint;
import services.ClienteService;
import services.FilaAtendimentoService;
import services.PlanoService;

public class Program {

    public static void main(String[] args) {
        String endereco1 = "http://localhost:9999/v1/atendimento";
        String endereco2 = "http://localhost:9999/v1/clientes";
        String endereco3 = "http://localhost:9999/v1/planos";
        
        Endpoint.publish(endereco1, new FilaAtendimentoService());
        Endpoint.publish(endereco2, new ClienteService());
        Endpoint.publish(endereco3, new PlanoService());
    }
    
}
