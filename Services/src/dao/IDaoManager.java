package dao;

public interface IDaoManager {
    
    void iniciar();
    void encerrar();
    void confirmarTransacao();
    void abortarTransacao();
    ClienteDao getClienteDao();
    PlanoDao getPlanoDao();
}
