package system.pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import define.define;
public class Pessoa {
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String email;
    private String senha;

    public Pessoa(String nome, String data_nascimento, String sexo, String email, String senha) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
    }

    public Pessoa() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //CRUD
    //retorna o id da pessoa inserida   
    public static int AddPessoa(Pessoa pessoa) {
        int id;
        int respostaID = BuscarPessoaLoginSenha(pessoa.getEmail(), pessoa.getSenha());
        System.out.println("Respondeu:"+respostaID);
        if (respostaID== -1){
            String sqlInsert = "INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('atr_nome','atr_data_nascimento','atr_sexo','atr_email','atr_email')";
            sqlInsert = sqlInsert.replace("atr_nome", pessoa.getNome());
            sqlInsert = sqlInsert.replace("atr_data_nascimento", pessoa.getData_nascimento());
            sqlInsert = sqlInsert.replace("atr_sexo", pessoa.getSexo());
            sqlInsert = sqlInsert.replace("atr_email", pessoa.getEmail());
            sqlInsert = sqlInsert.replace("atr_senha", pessoa.getSenha());
            define.connectionJDBC.ExecuteCommand(sqlInsert);
            id = BuscarPessoaLoginSenha(pessoa.getEmail(), pessoa.getSenha());                
            System.out.println("Resposta da adicção:"+id);
            String Add_LVL=null;
            if (pessoa.getClass().getSimpleName().equals("High_lvl")) {
                System.out.println("Adicionar pessoa High_lvl");
                High_lvl p_hl = (High_lvl) pessoa;
                Add_LVL = "INSERT INTO High_lvl(id,interesse) values ("+id+",'"+p_hl.getInteresse()+"')";                
            } else {
                Low_lvl p_ll = (Low_lvl) pessoa;
                Add_LVL = "INSERT INTO Low_lvl(id,empresa,formacao_tecnica) VALUES ("+id+",'"+p_ll.getEmpresa()+"','"+p_ll.getFormacao_tecnica()+"')";
            }
            define.connectionJDBC.ExecuteCommand(Add_LVL);
        }else{
            id = -1;
        }
        return id;
    }

    //Retorna o id da pessoa alterada
    public static int UptadePessoa(Pessoa pessoaAntiga, Pessoa novaPessoa) {
        int id = -1;
        if (pessoaAntiga.getClass().getSimpleName().equals(novaPessoa.getClass().getSimpleName())){
            String sqlUpdate;
            id = BuscarPessoaLoginSenha(pessoaAntiga.getEmail(), pessoaAntiga.getSenha());
            if (pessoaAntiga.getClass().getSimpleName().equals("High_lvl")) {
                sqlUpdate = "UPDATE High_lvl SET interesse='" + (((High_lvl) novaPessoa).getInteresse()) + "' WHERE id=" + id;
                define.connectionJDBC.ExecuteCommand(sqlUpdate);
                sqlUpdate = "UPDATE Pessoa SET Nome='" + novaPessoa.getNome() + "',data_nascimento='" + novaPessoa.getData_nascimento() + "',sexo='" + novaPessoa.getSexo() + "' WHERE id=" + id;
                define.connectionJDBC.ExecuteCommand(sqlUpdate);
                System.out.println(sqlUpdate);
            } else {
                sqlUpdate = "UPDATE Low_lvl SET empresa='" + (((Low_lvl) novaPessoa).getEmpresa()) + "',formacao_tecnica='" + (((Low_lvl) novaPessoa).getFormacao_tecnica()) + "' WHERE id=" + id;
                define.connectionJDBC.ExecuteCommand(sqlUpdate);
                sqlUpdate = "UPDATE Pessoa SET Nome='" + novaPessoa.getNome() + "',data_nascimento='" + novaPessoa.getData_nascimento() + "',sexo='" + novaPessoa.getSexo() + "' WHERE id=" + id;
                define.connectionJDBC.ExecuteCommand(sqlUpdate);
                System.out.println(sqlUpdate);
            }
        }
        return id;
    }

    //Retorna o id da pessoa buscada    
    public static int ReadPessoa(Pessoa pessoa){
        int id = -1;
        if(pessoa.getClass().getSimpleName().equals("High_lvl")){
            System.out.println("Read pessoa High_lvl");
        }else{
            System.out.println("Read pessoa Low_lvl");
        }
        return id;
    }
    //Retorna o id da pessoa deletada
    public static int DeletePessoa(Pessoa pessoa){
        int id = -1;
        if(pessoa.getClass().getSimpleName().equals("High_lvl")){
            System.out.println("Deletar pessoa High_lvl");
        } else {
            System.out.println("Deletar pessoa Low_lvl");
        }
        return id;
    }

    //Funções Pessoa
    //Retorna id da pessoa buscada, caso não ache retorna -1
    public static int BuscarPessoaLoginSenha(String email, String senha) {
        int id = -1;
        try {
            String sqlBusca = "SELECT id FROM Pessoa where Pessoa.email='" + email + "' AND Pessoa.senha='" + senha + "'";
            ResultSet result = define.connectionJDBC.ExecuteQuery(sqlBusca);
            if(result!=null){
                while (result.next()) {
                    id = result.getInt("id");
                }
            }
        } catch (SQLException e) {
        }        
        return id;
    }   
    
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", data_nascimento=" + data_nascimento + ", sexo=" + sexo + ", email=" + email + ", senha=" + senha + '}';
    }
    
}
