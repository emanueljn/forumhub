create table topicos (

    id bigint not null auto_increment,
    title varchar(100) not null unique,
    mensagem varchar(510) not null unique,
    dataCriacao date not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    respostas varchar(510) not null,


    primary key(id)

);