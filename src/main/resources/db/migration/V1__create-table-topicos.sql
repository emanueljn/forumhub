create table topicos (

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(510) not null unique,
    data_criacao date,
    autor varchar(100) not null,
    curso varchar(100) not null,
    respostas varchar(510),
    status ENUM ('SEM_RESPOSTA', 'RESPONDIDO') DEFAULT 'SEM_RESPOSTA',


    primary key(id)

);
