# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table disciplina (
  id                        varchar(255) not null,
  nome                      varchar(255) not null,
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
  constraint uq_disciplina_nome unique (nome),
  constraint pk_disciplina primary key (id))
;

create table periodo (
  id                        varchar(255) not null,
  menor_num_periodo         integer,
  maior_num_periodo         integer,
  total_de_creditos         integer,
  total_de_dificuldade      integer,
  numero                    integer,
  constraint pk_periodo primary key (id))
;

create table plano_de_curso (
  id                        varchar(255) not null,
  periodo_maximo            integer,
  maximo_de_creditos        integer,
  periodos_base             integer,
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  email                     varchar(255) not null,
  nome                      varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (email))
;

create sequence disciplina_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists disciplina;

drop table if exists periodo;

drop table if exists plano_de_curso;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

