# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Disciplina (
  codigo                    varchar(255) not null,
  nome                      varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
  constraint pk_Disciplina primary key (codigo))
;

create table periodo (
  id                        bigint not null,
  menor_num_periodo         integer,
  maior_num_periodo         integer,
  minimo_creditos           integer,
  total_de_creditos         integer,
  total_de_dificuldade      integer,
  numero                    integer,
  constraint pk_periodo primary key (id))
;

create table plano_de_curso (
  id                        bigint not null,
  periodo_maximo            integer,
  maximo_de_creditos        integer,
  minimo_de_creditos        integer,
  periodos_base             integer,
  usuario_id                bigint,
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  id                        bigint not null,
  email                     varchar(255),
  nome                      varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id))
;


create table dependencias (
  dependente                     varchar(255) not null,
  requisito                      varchar(255) not null,
  constraint pk_dependencias primary key (dependente, requisito))
;

create table periodo_Disciplina (
  periodo_id                     bigint not null,
  Disciplina_codigo              varchar(255) not null,
  constraint pk_periodo_Disciplina primary key (periodo_id, Disciplina_codigo))
;

create table plano_de_curso_Disciplina (
  plano_de_curso_id              bigint not null,
  Disciplina_codigo              varchar(255) not null,
  constraint pk_plano_de_curso_Disciplina primary key (plano_de_curso_id, Disciplina_codigo))
;

create table plano_de_curso_periodo (
  plano_de_curso_id              bigint not null,
  periodo_id                     bigint not null,
  constraint pk_plano_de_curso_periodo primary key (plano_de_curso_id, periodo_id))
;
create sequence Disciplina_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;

alter table plano_de_curso add constraint fk_plano_de_curso_usuario_1 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_plano_de_curso_usuario_1 on plano_de_curso (usuario_id);



alter table dependencias add constraint fk_dependencias_Disciplina_01 foreign key (dependente) references Disciplina (codigo) on delete restrict on update restrict;

alter table dependencias add constraint fk_dependencias_Disciplina_02 foreign key (requisito) references Disciplina (codigo) on delete restrict on update restrict;

alter table periodo_Disciplina add constraint fk_periodo_Disciplina_periodo_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_Disciplina add constraint fk_periodo_Disciplina_Discipl_02 foreign key (Disciplina_codigo) references Disciplina (codigo) on delete restrict on update restrict;

alter table plano_de_curso_Disciplina add constraint fk_plano_de_curso_Disciplina__01 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;

alter table plano_de_curso_Disciplina add constraint fk_plano_de_curso_Disciplina__02 foreign key (Disciplina_codigo) references Disciplina (codigo) on delete restrict on update restrict;

alter table plano_de_curso_periodo add constraint fk_plano_de_curso_periodo_pla_01 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;

alter table plano_de_curso_periodo add constraint fk_plano_de_curso_periodo_per_02 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Disciplina;

drop table if exists dependencias;

drop table if exists periodo;

drop table if exists periodo_Disciplina;

drop table if exists plano_de_curso;

drop table if exists plano_de_curso_Disciplina;

drop table if exists plano_de_curso_periodo;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

