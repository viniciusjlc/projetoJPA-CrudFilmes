CREATE TABLE public.perfis (
	id serial NOT NULL,
	nome varchar(120) NULL,
	CONSTRAINT perfis_pkey PRIMARY KEY (id)
);

CREATE TABLE public.usuarios (
	id serial NOT NULL,
	nome varchar(120) NULL,
	data_nascimento date NULL,
	cpf bpchar(11) NULL,
	email varchar(100) NOT NULL,
	senha varchar(60) NULL,
	celular bpchar(9) NULL,
	genero bpchar(1) NULL,
	foto bytea NULL,
	data_hora_criacao timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	data_hora_ultima_modificacao timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	ativo bool NULL DEFAULT true,
	id_perfil int4 NOT NULL DEFAULT 1,
	CONSTRAINT usuarios_cpf_key UNIQUE (cpf),
	CONSTRAINT usuarios_email_key UNIQUE (email),
	CONSTRAINT usuarios_pkey PRIMARY KEY (id),
	CONSTRAINT perfil_fk FOREIGN KEY (id_perfil) REFERENCES perfis(id)
);

CREATE TABLE public.generos (
	id serial NOT NULL,
	nome varchar(80) NOT NULL,
	descricao varchar(1000) NULL,
	CONSTRAINT generos_pk PRIMARY KEY (id)
);

CREATE TABLE public.classificacoes_indicativas (
	id serial NOT NULL,
	descricao varchar(500) NOT NULL,
	descricao_resumida varchar(200) NOT NULL,
	cor varchar(50) NOT NULL,
	CONSTRAINT classificacoes_indicativas_pk PRIMARY KEY (id)
);

CREATE TABLE public.filmes (
	id serial NOT NULL,
	nome varchar(200) NOT NULL,
	sinopse varchar(800) NULL,
	id_categoria int4 NOT NULL,
	id_classificacao_indicativa int4 NOT NULL,
	CONSTRAINT filmes_pk PRIMARY KEY (id),
	CONSTRAINT categoria_fk FOREIGN KEY (id_categoria) REFERENCES generos(id),
	CONSTRAINT classificacoes_indicativas_fk FOREIGN KEY (id_classificacao_indicativa) REFERENCES classificacoes_indicativas(id)
);

CREATE TABLE public.funcao_producao (
	id serial NOT NULL,
	nome varchar(500) NOT NULL,
	descricao varchar(500) NULL,
	CONSTRAINT funcao_producao_pkey PRIMARY KEY (id)
);

CREATE TABLE public.membros_producao (
	id serial NOT NULL,
	nome_ator varchar(500) NOT NULL,
	id_funcao int4 NOT NULL,
	CONSTRAINT membros_producao_pkey PRIMARY KEY (id),
	CONSTRAINT funcao_fk FOREIGN KEY (id_funcao) REFERENCES funcao_producao(id)
);

CREATE TABLE public.membros_filme (
	id serial NOT NULL,
	id_filme int4 NOT NULL,
	id_membro int4 NOT NULL,
	CONSTRAINT membros_filme_pkey PRIMARY KEY (id),
	CONSTRAINT filme_fk FOREIGN KEY (id_filme) REFERENCES filmes(id),
	CONSTRAINT membro_fk FOREIGN KEY (id_membro) REFERENCES membros_producao(id)
);


CREATE TABLE public.nota_filme (
	id serial NOT NULL,
	id_usuario int4 NOT NULL,
	id_filme int4 NOT NULL,
	nota int4 NOT NULL DEFAULT 0,
	CONSTRAINT nota_filme_pkey PRIMARY KEY (id),
	CONSTRAINT filme_fk FOREIGN KEY (id_filme) REFERENCES filmes(id),
	CONSTRAINT usuarios_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


INSERT INTO public.perfis (nome) VALUES ('Leitor');
INSERT INTO public.perfis (nome) VALUES ('Escritor');
INSERT INTO public.perfis (nome) VALUES ('Moderador');
INSERT INTO public.perfis (nome) VALUES ('Administrador');

INSERT INTO public.usuarios (nome,data_nascimento,cpf,email,senha,celular,genero,id_perfil)
VALUES ('admin','2000-01-01','00093604092','teste@teste.com','teste','999999999','M', 4);

INSERT INTO public.generos
(nome, descricao)
VALUES('Ação', 'É um gênero de filme que geralmente envolve uma história de protagonistas do bem contra antagonistas do mal, que resolvem suas disputas com o uso de força física, neles o bem sempre prevalece sobre o mal.');


INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('Livre','Recomendado para todas as idades', 'VERDE');
INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('10 Anos','Não Recomendado para menores de 10 anos', 'AZUL');
INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('12 Anos','Não Recomendado para menores de 12 anos', 'AMARELO');
INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('14 Anos','Não Recomendado para menores de 14 anos', 'LARANJA');
INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('16 Anos','Não Recomendado para menores de 16 anos', 'VERMELHO');
INSERT INTO public.classificacoes_indicativas (descricao_resumida,descricao,cor)
VALUES ('18 Anos','Proibido para menores de 18 anos', 'PRETO');

INSERT INTO public.funcao_producao (nome, descricao)
VALUES ('Ator','É a pessoa que interpreta e representa uma ação dramática baseando-se em textos, estímulos visuais, sonoros e outros, previamente concebidos por um autor ou criados através de improvisações individuais ou coletivas.');
INSERT INTO public.funcao_producao (nome, descricao)
VALUES ('Diretor','É considerado, em termos gerais, o criador da obra cinematográfica. Ainda que o seu papel seja diferente consoante o realizador em causa (que além de estilos diferentes, têm estratégias de trabalho igualmente diversas), o trabalho do diretor de cinema, ao supervisionar e dirigir a execução das filmagens.');
INSERT INTO public.funcao_producao (nome, descricao)
VALUES ('Produtor','É o profissional de cinema que atua na área empresarial. É o captador de recursos para um projeto por ele elaborado ou a empresa que o contratou.');

INSERT INTO public.filmes
(nome, id_categoria, id_classificacao_indicativa, sinopse)
VALUES('Vingadores', 1, 1, 'Teste');

INSERT INTO public.nota_filme
(id_usuario, id_filme, nota)
VALUES(1, 1, 10);

INSERT INTO public.membros_filme
(id_filme, id_membro)
VALUES(1, 1);


