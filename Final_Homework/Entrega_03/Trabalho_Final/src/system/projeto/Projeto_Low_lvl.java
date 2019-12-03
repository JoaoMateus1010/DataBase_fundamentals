package system.projeto;

import java.util.ArrayList;
import define.define;
import java.sql.SQLException;
public class Projeto_Low_lvl extends Projeto{
    private double vcc_info;
    private int num_pin_out_info;
    private int num_pin_in_info;
    private int gnd_info;

    public Projeto_Low_lvl(double vcc_info, int num_pin_out_info, int num_pin_in_info, int gnd_info, String nome, String descricao) {
        super(nome, descricao);
        this.vcc_info = vcc_info;
        this.num_pin_out_info = num_pin_out_info;
        this.num_pin_in_info = num_pin_in_info;
        this.gnd_info = gnd_info;
    }
    
    public double getVcc_info() {
        return vcc_info;
    }

    public void setVcc_info(double vcc_info) {
        this.vcc_info = vcc_info;
    }

    public int getNum_pin_out_info() {
        return num_pin_out_info;
    }

    public void setNum_pin_out_info(int num_pin_out_info) {
        this.num_pin_out_info = num_pin_out_info;
    }

    public int getNum_pin_in_info() {
        return num_pin_in_info;
    }

    public void setNum_pin_in_info(int num_pin_in_info) {
        this.num_pin_in_info = num_pin_in_info;
    }

    public int getGnd_info() {
        return gnd_info;
    }

    public void setGnd_info(int gnd_info) {
        this.gnd_info = gnd_info;
    }    
        public static int AddProjeto() {
        int id = -1;

        return id;
    }

    public static int DelProjeto(String nome) {
        int id = Projeto.BuscarProjetoNome(nome);
        if(id!=-1){
            String sqlDeleteLowProject = "DELETE FROM Projeto_Low_lvl WHERE id="+id;
            define.connectionJDBC.ExecuteCommand(sqlDeleteLowProject);
            Projeto.DelProjeto(nome);
        }else{
            return -1;
        }
        return id;
    }
    
    public static ArrayList<String> getProjectsByUser(int id) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sqlConsultaProjects = "SELECT nome FROM Projeto NATURAL JOIN Projeto_Low_lvl WHERE id_criador_projeto_low=" +id+" order by nome";
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
