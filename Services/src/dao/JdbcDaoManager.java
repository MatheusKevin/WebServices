package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDaoManager implements IDaoManager{
    private Connection conexao;
    private ClienteDao clienteDao;
    private PlanoDao planoDao;

    public JdbcDaoManager() {
    }
    
    @Override
    public void iniciar() throws DaoException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/telefonia";
            conexao = DriverManager.getConnection(url, "root", "root");
            conexao.setAutoCommit(false);
            clienteDao = new JdbcClienteDao(conexao);
            planoDao = new JdbcPlanoDao(conexao);
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados"+
                ex.getMessage());
            
        }
    }

    @Override
    public void encerrar() {
        try{
            if(!conexao.isClosed()){
                conexao.isClosed();
            }
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao encerrar a conexão: " 
			+ ex.getMessage());
        }
    }

    @Override
    public void confirmarTransacao() {
        try{
            conexao.commit();
        }catch(SQLException ex){
            throw new DaoException("Ocorreu um erro ao confirmar a transação" 
			+ ex.getMessage());
        }
    }

    @Override
    public void abortarTransacao() {
        try {
            conexao.rollback();
        } catch (SQLException ex){
            throw new DaoException("Ocorreu um erro ao abortar a transação" +
			ex.getMessage());
        }
    }

    @Override
    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    @Override
    public PlanoDao getPlanoDao() {
        return planoDao;
    }
 
}
