create table perfis(

    id bigint not null auto_increment,
    nome ENUM ('ADMINISTRADOR', 'INSTRUTOR', 'USUARIO'),

    primary key(id)

);


