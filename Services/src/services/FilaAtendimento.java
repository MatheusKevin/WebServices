package services;

import java.util.LinkedList;
import java.util.Queue;
import javax.jws.WebService;

@WebService
public class FilaAtendimento {
    private Integer n = 0;
    private Queue<Integer> fila = new LinkedList<Integer>();
    
    public Integer gerarSenha(){
        n++;
        fila.add(n);
        return n;
    }
    
    public Integer obterSenha(){
        if(fila.isEmpty())
            return -1;
        return fila.poll();
    }
}
