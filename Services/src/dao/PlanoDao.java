package dao;

import java.sql.ResultSet;
import java.util.List;
import model.Plano;

public interface PlanoDao {
    void alterarPlano(int id);
    Plano obterPlanoPorId(int id);
    List<Plano> obterTodos();
    Plano popularObjeto(ResultSet rs);
}
