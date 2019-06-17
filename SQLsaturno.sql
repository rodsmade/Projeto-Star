create database saturno;

use saturno;

create table dado_pessoal (
id_dado_pessoal integer primary key auto_increment not null,
nome varchar(100) not null,
sobrenome varchar(200) not null,
cpf varchar(11) not null,
cartao_de_credito int(16) not null,
email varchar(100) not null,
data_de_nascimento date not null,
foto_de_perfil varchar(1000),
genero tinyint unsigned not null,
cidade varchar(200) not null
-- chave estrangeira de usuario
);
describe dado_pessoal;

create table usuario(
id_usuario int primary key auto_increment not null,
nickname varchar(200) not null,

);

