package services;

import dao.ClienteDao;
import dao.IDaoManager;
import dao.JdbcDaoManager;
import dao.PlanoDao;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import model.Cliente;
import model.Plano;

@WebService
public class Planos {
    
    public Plano obterPlanoPorCliente(int idCliente){
        IDaoManager manager = new JdbcDaoManager();
        Cliente cliente = new Cliente();
        try{
            manager.iniciar();
            ClienteDao dao = manager.getClienteDao();
            cliente = dao.obterClientePorId(idCliente);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            manager.encerrar();
        }
        return cliente.getPlano();
    }
    
    public List<Plano> obterPlanos(){
        IDaoManager manager = new JdbcDaoManager();
        List<Plano> planos = new ArrayList<Plano>();
        try{
            manager.iniciar();
            PlanoDao dao = manager.getPlanoDao();
            planos = dao.obterTodos();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            manager.encerrar();
        }
        return planos;
    }
    
    public void alterarPlano(Plano plano){
        IDaoManager manager = new JdbcDaoManager();
        try{
            manager.iniciar();
            PlanoDao dao = manager.getPlanoDao();
            dao.alterarPlano(plano);
            manager.confirmarTransacao();
        }catch(Exception ex){
            manager.abortarTransacao();
            ex.printStackTrace();
        }finally{
            manager.encerrar();
        }
    }
}
