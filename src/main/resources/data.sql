create table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome , qtd_habitantes)
values
    (1, 'São Paulo', 123456789),
    (2, 'Rio de Janeiro', 123),
    (3, 'Fortaleza', 12345),
    (4, 'Salvador', 123456),
    (5, 'Belo Horizonte', 1234567),
    (6, 'Porto Alegre', 12345678),
    (7, 'Porto Velho', 123456789),
    (8, 'Palmas', 1234567890),
    (9, 'Recife', 12345678901),
    (10, 'Natal', 123456789012),
    (11, 'Brasilia', 1234567890123);