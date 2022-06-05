create database projetocervejaria;

create table usuario (
codigo serial primary key,

nomecliente varchar(100),
telefonecliente varchar(100),
logincliente varchar(100),
emailcliente varchar (100),
senhacliente varchar (100)
);
create table fornecedor(
codigo serial primary key,
razaosocial varchar(100),
cnpjfornecedor varchar(40),
telefonefornecedor varchar(20),
ruafornecedor varchar(100),
numfornecedor varchar(20),
cepfornecedor varchar(30),
emailfornecedor varchar(100),
estadofornecedor varchar(100),
cidadefornecedor varchar(100)

);

create table categoria(

codigo serial primary key,
nomecategoria varchar(100),
descricaocategoria varchar(100)
);