package dao;

import java.sql.ResultSet;
import java.util.List;
import model.Plano;

public interface PlanoDao {
    void alterarPlano(Plano plano);
    Plano obterPlanoPorId(int id);
    List<Plano> obterTodos();
    Plano popularObjeto(ResultSet rs);
}
