create table perfis(

    id bigint not null auto_increment,
    nome ENUM ('ADMINISTRADOR', 'INTRUTOR', 'USUARIO'),

    primary key(id)

);


