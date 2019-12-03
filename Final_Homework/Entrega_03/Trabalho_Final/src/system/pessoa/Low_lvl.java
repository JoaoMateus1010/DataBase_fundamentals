package system.pessoa;

import define.define;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Low_lvl extends Pessoa{
    private String empresa;
    private String formacao_tecnica;

    public Low_lvl(String empresa, String formacao_tecnica, String nome, String data_nascimento, String sexo, String email, String senha) {
        super(nome, data_nascimento, sexo, email, senha);
        this.empresa = empresa;
        this.formacao_tecnica = formacao_tecnica;
    }

    public Low_lvl() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFormacao_tecnica() {
        return formacao_tecnica;
    }

    public void setFormacao_tecnica(String formacao_tecnica) {
        this.formacao_tecnica = formacao_tecnica;
    }
    
    //CRUD
    //retorna o id da pessoa inserida    
    public static int AddPessoa(Pessoa pessoa){
        int id = Pessoa.AddPessoa(pessoa);
        
        return id;
    }
    //Retorna o id da pessoa alterada
    public static int UptadePessoa(Pessoa pessoaAntiga,Pessoa novaPessoa){
        int id = Pessoa.UptadePessoa(pessoaAntiga, novaPessoa);
        return id;
    }
    //Retorna o id da pessoa buscada    
    public static  int ReadPessoa(Pessoa pessoa){
        int id = -1;
        Pessoa.ReadPessoa(pessoa);
        return id;
    }
    //Retorna o id da pessoa deletada
    public static int DeletePessoa(Pessoa pessoa){
        int id = -1;
        Pessoa.DeletePessoa(pessoa);
        return id;
    }
    
    public static int loginLow_lvl(String email,String senha){
        int id = -1;
        if (Pessoa.BuscarPessoaLoginSenha(email, senha) != -1) {
            String sqlLow_lvl = "select * from pessoa natural join low_lvl where id="+Pessoa.BuscarPessoaLoginSenha(email, senha);       
            System.out.println(sqlLow_lvl);
            define.connectionJDBC.ExecuteQuery(sqlLow_lvl);
            try {
                while (define.connectionJDBC.getResultQuery().next()) {
                    id = define.connectionJDBC.getResultQuery().getInt("id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(High_lvl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("ID RETORNO:" + id);
        return id;
    }

    public static ArrayList<String> getListUsers() {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "select nome from Pessoa natural join low_lvl order by nome";
            define.connectionJDBC.ExecuteQuery(sql);
            while (define.connectionJDBC.getResultQuery().next()) {
                list.add(define.connectionJDBC.getResultQuery().getString("nome"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public String toString() {
        return "Low_lvl{" + "empresa=" + empresa + ", formacao_tecnica=" + formacao_tecnica + '}';
    }
    
}
