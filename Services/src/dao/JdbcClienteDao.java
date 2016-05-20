package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import model.Cliente;

public class JdbcClienteDao implements ClienteDao{
    private final Connection conexao;

    public JdbcClienteDao(Connection conexao) {
        this.conexao = conexao;
    }
    

    @Override
    public Cliente obterClientePorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente popularObjeto(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
