package dao;

import java.sql.ResultSet;
import model.Cliente;

public interface ClienteDao {
    Cliente obterClientePorId(int id);
    Cliente popularObjeto(ResultSet rs);
}
