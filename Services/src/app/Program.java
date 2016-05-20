package app;

import javax.xml.ws.Endpoint;
import services.Clientes;
import services.FilaAtendimento;
import services.Planos;

public class Program {

    public static void main(String[] args) {
        String endereco1 = "http://192.168.25.5:9999/v1/atendimento";
        String endereco2 = "http://192.168.25.5:9999/v1/clientes";
        String endereco3 = "http://192.168.25.5:9999/v1/planos";
        
        Endpoint.publish(endereco1, new FilaAtendimento());
        Endpoint.publish(endereco2, new Clientes());
        Endpoint.publish(endereco3, new Planos());
    }
    
}
