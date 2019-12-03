package system.pessoa;
import define.define;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class High_lvl extends Pessoa{
    private String interesse;

    public High_lvl(String interesse, String nome, String data_nascimento, String sexo, String email, String senha) {
        super(nome, data_nascimento, sexo, email, senha);
        this.interesse = interesse;
    }

    public High_lvl(String interesse) {
        this.interesse = interesse;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
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
    public static int ReadPessoa(Pessoa pessoa){
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
    //
    public static int loginHigh_lvl(String email, String senha) {
        int id = -1;
        if (Pessoa.BuscarPessoaLoginSenha(email, senha) != -1) {
            String sqlHigh_lvl = "select * from pessoa natural join high_lvl where id="+Pessoa.BuscarPessoaLoginSenha(email, senha);       
            System.out.println(sqlHigh_lvl);
            define.connectionJDBC.ExecuteQuery(sqlHigh_lvl);
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
            String sql = "select nome from Pessoa natural join high_lvl order by nome";
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
        return "High_lvl{" + "interesse=" + interesse + '}';
    }

}
