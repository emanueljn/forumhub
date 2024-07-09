create table respostas(

    id bigint not null auto_increment,
    usuario_id bigint not null,
    topico_id bigint not null,
    mensagem varchar(510) not null,
    data_criacao datetime not null,
    solucao varchar(510) not null,

    primary key(id),
    constraint fk_respostas_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id)

);