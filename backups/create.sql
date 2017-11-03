create table topicos (
	id serial primary key,
	nome varchar(200) not null,
	descricao varchar(500) null,
	concursoId integer not null references concursos
);

create table simulados (
	id serial primary key,
	concursoId integer not null references concursos,
	criado timestamp not null default current_timestamp
);

create table questoes (
	id serial primary key,
	topicoId integer not null references topicos,
	enunciado varchar(500) not null
);

create table alternativas (
	id serial primary key,
	questaoId integer not null references questoes,
	enunciado varchar(500) not null,
	correta bool not null default false
);

create table simulados_questoes (
	simuladoId integer not null references simulados,
	questaoId integer not null references questoes,
	primary key (simuladoId, questaoId)
);

create table simulados_respostas (
	id serial primary key,
	simuladoId integer not null references simulados,
	questaoId integer not null references questoes,
	alernativaId integer references alternativas
);