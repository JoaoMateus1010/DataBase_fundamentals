package system.projeto;
import define.define;
import java.sql.SQLException;
import java.util.ArrayList;
import system.pessoa.High_lvl;
public class Projeto {
    private String nome;
    private String descricao;
    
    public Projeto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Projeto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
         
    //CRUD
    //Retorna o id do projeto criado
    public static int AddProjeto(Projeto AddProjeto,int IdCriador) {
        int id = BuscarProjetoNome(AddProjeto.getNome());        
        if (id == -1) {
            String sqlCreateProject = "INSERT INTO Projeto(nome,descricao) VALUES ('"+AddProjeto.getNome()+"','"+AddProjeto.getDescricao()+"')";
            System.out.println(sqlCreateProject);
            define.connectionJDBC.ExecuteCommand(sqlCreateProject);
            id = BuscarProjetoNome(AddProjeto.getNome());
            if (AddProjeto.getClass().getSimpleName().equals("Projeto_High_lvl")) {
                String sqlCreateProjectHigh = "INSERT INTO Projeto_High_lvl(id,id_criador_projeto_high,num_output,num_input) VALUES ("+(id)+","+IdCriador+","+(((Projeto_High_lvl)AddProjeto).getNum_output())+","+(((Projeto_High_lvl)AddProjeto).getNum_input())+")";                
                define.connectionJDBC.ExecuteCommand(sqlCreateProjectHigh);
            } else {                
                String sqlCreateProjectLow = "INSERT INTO Projeto_Low_lvl(id,id_criador_projeto_low,vcc_info,num_pin_out_info,num_pin_in_info,gnd_info) VALUES ("+(id)+","+IdCriador+","+(((Projeto_Low_lvl)AddProjeto).getVcc_info())+","+(((Projeto_Low_lvl)AddProjeto).getNum_pin_out_info())+","+(((Projeto_Low_lvl)AddProjeto).getNum_pin_in_info())+","+(((Projeto_Low_lvl)AddProjeto).getGnd_info())+")";                
                define.connectionJDBC.ExecuteCommand(sqlCreateProjectLow);
            }
        }else{
            return -1;
        }
        return id;
    }

    public static int DelProjeto(String nome) {
        int id = BuscarProjetoNome(nome);
        try {
            if(id!=-1){
                String sqlDelProjeto = "DELETE FROM Projeto WHERE id="+id;
                define.connectionJDBC.ExecuteCommand(sqlDelProjeto);
            }else{
                return -1;
            }
        } catch (Exception e) {
            
        }
        return id;
    }
    //Retorna o projeto com o nome passado
    public static int BuscarProjetoNome(String nome){
        int id = -1;
        try {
            String sqlQuery = "SELECT id FROM Projeto WHERE nome='"+nome+"'";
            define.connectionJDBC.ExecuteQuery(sqlQuery);
            while (define.connectionJDBC.getResultQuery().next()) {                
                id = define.connectionJDBC.getResultQuery().getInt("id");
            }
        } catch (SQLException e) {
            return -1;
        }
        return id;
    }
    
    
}
