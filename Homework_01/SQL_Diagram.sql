-- Entidades
create table usuario(login varchar(50) primary key,p_nome varchar(30),u_nome varchar(30));
create table playlist(id serial primary key,nome varchar(50),dono_playlist varchar(50),foreign key (dono_playlist) references usuario(login));
create table musica(id serial primary key,titulo varchar(50),duracao integer);
create table artista(id serial primary key,tipo varchar(50),nome varchar(50));
-- Atributos Multivalorados
create table genero_musical(login_usuario varchar(50),genero varchar(50),foreign key (login_usuario) references usuario(login));
-- Relações
create table segue(login_usuario varchar(50),id_playlist integer,foreign key (login_usuario) references usuario(login),foreign key (id_playlist) references playlist(id));
create table tem_playlist_musica(id_playlist integer,id_musica integer,foreign key (id_playlist) references playlist(id),foreign key (id_musica) references musica(id));
create table tem_musica_artista(id_musica integer,id_artista integer,foreign key (id_musica) references musica(id),foreign key (id_artista) references artista(id));
--Popular
insert into usuario(login,p_nome,u_nome) values ('jm@gmail.com','João','Mateus');
insert into usuario(login,p_nome,u_nome) values ('mr@gmail.com','Maria','Rosa');
insert into usuario(login,p_nome,u_nome) values ('ls@gmail.com','Lucas','Sousa');
insert into usuario(login,p_nome,u_nome) values ('ph@gmail.com','Pedro','Henrique');
insert into usuario(login,p_nome,u_nome) values ('bc@gmail.com','Beatriz','Macedo');

select * from usuario;

insert into artista(nome,tipo) values ('Guns','Rock');
insert into artista(nome,tipo) values ('racionais','Rap');
insert into artista(nome,tipo) values ('Bob','Reggae');
insert into artista(nome,tipo) values ('Michael Jack','Pop');
insert into artista(nome,tipo) values ('The White Buffalo','Country');

select * from artista;

insert into musica(titulo,duracao) values ('Superman',1549);
insert into musica(titulo,duracao) values ('Knockin On Heavens Door',1683);
insert into musica(titulo,duracao) values ('I Got You ft Audra Mae',1683);
insert into musica(titulo,duracao) values ('Jesus Chorou',1982);
insert into musica(titulo,duracao) values ('Is This Love',1283);

select * from musica;

insert into playlist(nome,dono_playlist) values ('play01','jm@gmail.com');
insert into playlist(nome,dono_playlist) values ('play02','ph@gmail.com');
insert into playlist(nome,dono_playlist) values ('play04','ls@gmail.com');
insert into playlist(nome,dono_playlist) values ('play03','bc@gmail.com');
insert into playlist(nome,dono_playlist) values ('play05','jm@gmail.com');

select * from playlist;

insert into genero_musical(login_usuario,genero) values ('jm@gmail.com','Rock');
insert into genero_musical(login_usuario,genero) values ('bc@gmail.com','Rock');
insert into genero_musical(login_usuario,genero) values ('ph@gmail.com','Hip-Hop');
insert into genero_musical(login_usuario,genero) values ('bc@gmail.com','Country');
insert into genero_musical(login_usuario,genero) values ('mr@gmail.com','Rock');

select * from genero_musical;

insert into segue values ('jm@gmail.com',5);
insert into segue values ('ph@gmail.com',5);
insert into segue values ('bc@gmail.com',5);
insert into segue values ('mr@gmail.com',2);
insert into segue values ('ls@gmail.com',3);

select * from segue;

insert into tem_playlist_musica values (1,1);
insert into tem_playlist_musica values (2,2);
insert into tem_playlist_musica values (3,1);
insert into tem_playlist_musica values (3,4);
insert into tem_playlist_musica values (4,2);

select * from tem_playlist_musica;

insert into tem_musica_artista values (1,1);
insert into tem_musica_artista values (2,2);
insert into tem_musica_artista values (3,1);
insert into tem_musica_artista values (3,4);
insert into tem_musica_artista values (4,2);

select * from tem_musica_artista;
