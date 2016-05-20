package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import model.Plano;

public class JdbcPlanoDao implements PlanoDao{
    private final Connection conexao;

    public JdbcPlanoDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void alterarPlano(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Plano obterPlanoPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plano> obterTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Plano popularObjeto(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
