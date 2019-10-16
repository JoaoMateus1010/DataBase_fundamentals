--Pessoa
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Maria','2009/10/15','f','111@gmail.com','123');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Jose','2008/09/14','m','222@gmail.com','456');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Guilherme','2007/08/13','m','333@gmail.com','789');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Francisca','2008/07/12','f','444@gmail.com','147');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Josefa','2007/06/11','m','555@gmail.com','258');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Carlos','2008/05/10','m','666@gmail.com','369');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Beatriz','2007/04/09','f','777@gmail.com','159');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Karla','2006/03/08','f','888@gmail.com','357');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Corey','1973/12/8','m','999@gmail.com','666');
INSERT INTO Pessoa(nome,Data_nascimento,sexo,email,senha) values ('Roberto','2005/02/5','m','101@gmail.com','777');

select * from Pessoa;
--Low_lvl
INSERT INTO Low_lvl(id,empresa,formacao_tecnica) values (1,'AAAA','engenharia eletrica');
INSERT INTO Low_lvl(id,empresa,formacao_tecnica) values (3,'BBBB','engenheira mecanica');
INSERT INTO Low_lvl(id,empresa,formacao_tecnica) values (5,'CCCC',null);
INSERT INTO Low_lvl(id,empresa,formacao_tecnica) values (7,'DDDD','engenheira computacao');
INSERT INTO Low_lvl(id,empresa,formacao_tecnica) values (9,'EEEE','ciencia da computacao');

select * from Low_lvl;

--High_lvl
INSERT INTO High_lvl(id,interesse) values (2,'apenas gosto');
INSERT INTO High_lvl(id,interesse) values (4,'trabalho');
INSERT INTO High_lvl(id,interesse) values (6,null);
INSERT INTO High_lvl(id,interesse) values (8,'curiosidade');
INSERT INTO High_lvl(id,interesse) values (10,'universidade');

select * from High_lvl;

--Projeto
INSERT INTO Projeto(nome,data_criacao,descricao) values ('Pojeto eletrico','2019/9/15','Projeto de criação de um prototipo eletrico');
INSERT INTO Projeto(nome,data_criacao,descricao) values ('Teste de uso','2019/10/16','Teste de uso do projeto eletrico');

select * from Projeto;

--Projeto_Low_lvl
INSERT INTO Projeto_Low_lvl(id,id_criador_projeto_low,vcc_info,num_pin_out_info,num_pin_in_info,gnd_info) values (1,5,13.5,2,1,0.0);

select * from Projeto_Low_lvl;

--Projeto_High_lvl
INSERT INTO Projeto_High_lvl(id,id_criador_projeto_high,num_output,num_input) values (2,8,2,1);

select * from Projeto_High_lvl;

--Component
INSERT INTO Component(id_criador_componente,nome,fabrica,i_max,i_min,v_max,v_min) values (9,'Multiplicador 2','Teste',1,0.005,12,0.32);

select * from Component;

--inputs
INSERT INTO inputs(id,input_pin_number,pin_in_value) values (13,1,2);

select * from inputs;

--outputs 
INSERT INTO inputs(id,output_pin_number,pin_output_value) values (13,1,null);

select * from inputs;