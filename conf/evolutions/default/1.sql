# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Disciplina (
  id                        varchar(255) not null,
  nome                      varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  constraint pk_Disciplina primary key (id))
;

create table periodo (
  id                        varchar(255) not null,
  maximo_de_creditos        integer,
  minimo_de_creditos        integer,
  menor_num_periodo         integer,
  maior_num_periodo         integer,
  numero                    integer,
  total_de_creditos         integer,
  total_de_dificuldade      integer,
  constraint pk_periodo primary key (id))
;

create table plano_de_curso (
  id                        varchar(255) not null,
  periodo_maximo            integer,
  periodos_base             integer,
  minimi_de_creditos_do_curso integer,
  periodo_atual             integer,
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  id                        varchar(255) not null,
  email                     varchar(255),
  nome                      varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id))
;


create table dependencias (
  disciplina                     varchar(255) not null,
  preRequisito                   varchar(255) not null,
  constraint pk_dependencias primary key (disciplina, preRequisito))
;

create table periodo_Disciplina (
  periodo_id                     varchar(255) not null,
  Disciplina_id                  varchar(255) not null,
  constraint pk_periodo_Disciplina primary key (periodo_id, Disciplina_id))
;

create table plano_disc_nao_alocadas (
  plano                          varchar(255) not null,
  disciplina                     varchar(255) not null,
  constraint pk_plano_disc_nao_alocadas primary key (plano, disciplina))
;

create table plano_periodos (
  plano                          varchar(255) not null,
  periodo                        varchar(255) not null,
  constraint pk_plano_periodos primary key (plano, periodo))
;
create sequence Disciplina_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;




alter table dependencias add constraint fk_dependencias_Disciplina_01 foreign key (disciplina) references Disciplina (id) on delete restrict on update restrict;

alter table dependencias add constraint fk_dependencias_Disciplina_02 foreign key (preRequisito) references Disciplina (id) on delete restrict on update restrict;

alter table periodo_Disciplina add constraint fk_periodo_Disciplina_periodo_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_Disciplina add constraint fk_periodo_Disciplina_Discipl_02 foreign key (Disciplina_id) references Disciplina (id) on delete restrict on update restrict;

alter table plano_disc_nao_alocadas add constraint fk_plano_disc_nao_alocadas_pl_01 foreign key (plano) references plano_de_curso (id) on delete restrict on update restrict;

alter table plano_disc_nao_alocadas add constraint fk_plano_disc_nao_alocadas_Di_02 foreign key (disciplina) references Disciplina (id) on delete restrict on update restrict;

alter table plano_periodos add constraint fk_plano_periodos_plano_de_cu_01 foreign key (plano) references plano_de_curso (id) on delete restrict on update restrict;

alter table plano_periodos add constraint fk_plano_periodos_periodo_02 foreign key (periodo) references periodo (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Disciplina;

drop table if exists dependencias;

drop table if exists periodo;

drop table if exists periodo_Disciplina;

drop table if exists plano_de_curso;

drop table if exists plano_disc_nao_alocadas;

drop table if exists plano_periodos;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

