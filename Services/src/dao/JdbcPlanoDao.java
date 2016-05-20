package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "SELECT * FROM planos"
                + "WHERE idPlano = ?";
        Plano plano = new Plano();
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                plano = popularObjeto(rs);
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao selecionar do banco: " 
			+ ex.getMessage());
        }
        return plano;
    }

    @Override
    public List<Plano> obterTodos() {
        String sql = "SELECT * FROM planos";
        List<Plano> planos = new ArrayList<Plano>();
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                planos.add(popularObjeto(rs));
            }
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao selecionar do banco: " 
			+ ex.getMessage());
        }
        return planos;
    }

    @Override
    public Plano popularObjeto(ResultSet rs) {
        Plano plano = new Plano();
        try {
            plano.setIdPlano(rs.getInt("idPlano"));
            plano.setNome(rs.getString("nome"));
            plano.setDescricao(rs.getString("descricao"));
            plano.setValor(rs.getFloat("valor"));
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao selecionar do banco: " 
			+ ex.getMessage());
        }
        return plano;
    }
    
}
