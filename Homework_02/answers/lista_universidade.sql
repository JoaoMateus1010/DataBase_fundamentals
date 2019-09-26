--Questão 1:
select nome from Professor,Pessoa where Pessoa.matricula_pessoa=Professor.matricula_professor
--Questão 2:
select * from Pessoa, Aluno, Curso where Pessoa.matricula_pessoa=Aluno.matricula_aluno and Curso.codigo_curso=Aluno.codigo_curso and Curso.nome='Sistemas de Informacao'
--Questão 3:
select Disciplina.ementa from Disciplina,Pessoa,Professor,ministra,Turma where (Pessoa.matricula_pessoa=Professor.matricula_professor and Pessoa.nome='Jose Alcantara' and Disciplina.codigo_disciplina=Turma.codigo_disciplina and Turma.ano_semestre=ministra.ano_semestre)
--Questão 4:
select * from Pessoa,Professor,ministra,Turma where Pessoa.matricula_pessoa=Professor.matricula_professor and Pessoa.nome='Jose Alcantara' and  Professor.matricula_professor=ministra.matricula_professor and Turma.ano_semestre='2008.2' and ministra.ano_semestre=Turma.ano_semestre
--Questão 5:
select Pessoa.nome from Pessoa, Aluno,Aluno_Turma where Pessoa.matricula_pessoa=Aluno.matricula_aluno and Aluno_Turma.matricula_aluno=Aluno.matricula_aluno and Aluno_Turma.ano_semestre='2009.2'
--Questão 6:
select Pessoa.nome from Pessoa, Professor,ministra,Turma,Curso where (Pessoa.matricula_pessoa=Professor.matricula_professor and Professor.matricula_professor=ministra.matricula_professor and ministra.ano_semestre=Turma.ano_semestre and Turma.ano_semestre='2009.1' and Turma.codigo_curso=Curso.codigo_curso and Curso.nome='Engeharia da Computacao')
--Questão 7:
select Pessoa.nome,prova.nota from Turma,Aluno_Turma,prova,Aluno,Pessoa where (Pessoa.matricula_pessoa=Aluno.matricula_aluno and Turma.ano_semestre=Aluno_Turma.ano_semestre)
--Questão 8:
select Pessoa.nome from Pessoa,Aluno,monitoria where Pessoa.matricula_pessoa=Aluno.matricula_aluno and monitoria.ano_semestre='2009.1'
--Questão 9:
select Projeto.titulo,prova.nota from Pessoa, Aluno, Aluno_Turma, Projeto,prova where Pessoa.nome='Fabiana Murer' and Pessoa.matricula_pessoa=Aluno.matricula_aluno and Aluno.matricula_aluno=Aluno_Turma.matricula_aluno and Projeto.codigo_projeto=Aluno_Turma.codigo_projeto and prova.matricula_aluno=Aluno_Turma.matricula_aluno
--Questão 10:
select Pessoa.nome,Curso.nome from Pessoa,Aluno,Curso where Pessoa.matricula_pessoa=Aluno.matricula_aluno and Aluno.nota_vestibular>5 and Aluno.codigo_curso=Curso.codigo_curso
--Questão 11:
select Disciplina.codigo_disciplina from  Disciplina, Curso,Turma where Curso.nome='Matematica' and Curso.codigo_curso=Turma.codigo_curso and Turma.codigo_disciplina=Disciplina.codigo_disciplina