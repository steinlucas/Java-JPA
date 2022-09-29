create table procedimento(
id_proc int primary key not null auto_increment,
desc_proc varchar(250),
valor_proc int(10),
data_proc varchar(10)
);




create table cliente(
id_cli int primary key not null auto_increment,
nome varchar(250) not null,
telefone varchar(30) not null,
cpf int (11) not null
);




create table procedimento_cliente(
id_reg int primary key not null auto_increment,
id_proc int,
id_cliente int,

FOREIGN KEY (id_proc)
REFERENCES procedimento (id_proc),
        
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cli)
);