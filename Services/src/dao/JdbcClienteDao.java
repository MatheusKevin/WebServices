package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;

public class JdbcClienteDao implements ClienteDao{
    private final Connection conexao;

    public JdbcClienteDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public Cliente obterClientePorId(int id) {
        String sql = "SELECT * FROM clientes"
                + "WHERE idCliente = ?";
        Cliente cliente = new Cliente();
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                cliente = popularObjeto(rs);
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao selecionar do banco: " 
			+ ex.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente popularObjeto(ResultSet rs) {
        Cliente cliente = new Cliente();
        IDaoManager manager = new JdbcDaoManager();
        try {
            manager.iniciar();
            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setRg(rs.getString("rg"));
            cliente.setPlano(manager.getPlanoDao().obterPlanoPorId(rs.getInt("idPlano")));
            manager.encerrar();
        } catch (SQLException ex) {
            manager.encerrar();
            throw new DaoException("Ocorreu um erro ao selecionar do banco: " 
			+ ex.getMessage());
        }
        return cliente;
    }
    
}
