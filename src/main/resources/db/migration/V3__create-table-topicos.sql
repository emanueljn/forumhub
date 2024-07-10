create table topicos (

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(510) not null unique,
    data_criacao datetime not null,
    usuario_id bigint not null,
    curso varchar(100) not null,
    respostas varchar(510),
    status ENUM ('SEM_RESPOSTA', 'RESPONDIDO') DEFAULT 'SEM_RESPOSTA',


    primary key(id),
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)

);
