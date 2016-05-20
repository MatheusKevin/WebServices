package services;

import dao.ClienteDao;
import dao.IDaoManager;
import dao.JdbcDaoManager;
import javax.jws.WebService;
import model.Cliente;

@WebService
public class Clientes {
    
    public Cliente obterCliente(int idCliente){
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
        return cliente;
    }
}
