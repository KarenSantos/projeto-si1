# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table curriculo (
  id                        varchar(255) not null,
  constraint pk_curriculo primary key (id))
;

create table disciplina (
  id                        varchar(255) not null,
  nome                      varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
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
  constraint pk_plano_de_curso primary key (id))
;

create sequence curriculo_seq;

create sequence disciplina_seq;

create sequence periodo_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists curriculo;

drop table if exists disciplina;

drop table if exists periodo;

drop table if exists plano_de_curso;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists curriculo_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

