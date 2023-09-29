insert into empresa (razao_social, cnpj)
    values ('Empresa 1', '00000000000000');

insert into usuario (nome, sobrenome, email, senha, empresa_id)
    values ('William', 'Marques', 'william@email.com', '$2a$10$iDkptniaGzQ7Prj0wgoPpOpcN/NrON2XVyEJVatc48heNcbcgcAd.', 1);

insert into setor (descricao, empresa_id)
    values ('setor 01', 1);

insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (12.0, 10.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (15.0, 17.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (18.0, 10.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (20.0, 10.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (23.0, 10.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (3.0, 17.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (1.0, 10.0, now(), 1);
insert into medida (umidade, temperatura, data_criacao, setor_id)
    values (99.0, 10.0, now(), 1);
