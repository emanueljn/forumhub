create table usuarios(

    id bigint not null auto_increment,
    perfil_id bigint not null,
    nome varchar(255) not null,
    login varchar(100) not null,
    senha varchar(255) not null,


    primary key(id),
    constraint fk_usuarios_perfil_id foreign key(perfil_id) references perfis(id)

);

