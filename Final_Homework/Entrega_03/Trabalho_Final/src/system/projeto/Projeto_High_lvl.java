package system.projeto;

import define.define;
import java.sql.SQLException;
import java.util.ArrayList;

public class Projeto_High_lvl extends Projeto{
    private int num_output;
    private int num_input;

    public Projeto_High_lvl(int num_output, int num_input, String nome, String descricao) {
        super(nome, descricao);
        this.num_output = num_output;
        this.num_input = num_input;
    }

    public Projeto_High_lvl(int num_output, int num_input) {
        this.num_output = num_output;
        this.num_input = num_input;
    }

    public int getNum_output() {
        return num_output;
    }

    public void setNum_output(int num_output) {
        this.num_output = num_output;
    }

    public int getNum_input() {
        return num_input;
    }

    public void setNum_input(int num_input) {
        this.num_input = num_input;
    }
        public static int AddProjeto() {
        int id = -1;

        return id;
    }

    public static int DelProjeto(String nome) {
        int id = Projeto.BuscarProjetoNome(nome);
        if (id != -1) {
            String sqlDeleteHighProject = "DELETE FROM Projeto_High_lvl WHERE id=" + id;
            define.connectionJDBC.ExecuteCommand(sqlDeleteHighProject);
            Projeto.DelProjeto(nome);
        } else {
            return -1;
        }
        return id;
    }
        public static ArrayList<String> getProjectsByUser(int id) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sqlConsultaProjects = "SELECT nome FROM Projeto NATURAL JOIN Projeto_High_lvl WHERE id_criador_projeto_high=" +id+" order by nome";
            System.out.println(sqlConsultaProjects);
            define.connectionJDBC.ExecuteQuery(sqlConsultaProjects);
            while (define.connectionJDBC.getResultQuery().next()) {                
                list.add(define.connectionJDBC.getResultQuery().getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na atualização da lista");
        } catch (NullPointerException np){
            
        }
        return list;
    }
}
