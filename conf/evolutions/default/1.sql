# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Disciplinas (
  Outroid                   varchar(255) not null,
  plano_de_curso_id         varchar(255) not null,
  nome                      varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
  constraint pk_Disciplinas primary key (Outroid))
;

create table grade (
  id                        varchar(255) not null,
  constraint pk_grade primary key (id))
;

create table periodo (
  id                        varchar(255) not null,
  plano_de_curso_id         varchar(255) not null,
  menor_num_periodo         integer,
  maior_num_periodo         integer,
  minimo_creditos           integer,
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
  grade_id                  varchar(255),
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  email                     varchar(255) not null,
  nome                      varchar(255),
  password                  varchar(255),
  plano_id                  varchar(255),
  constraint pk_usuario primary key (email))
;


create table Disciplinas_Disciplinas (
  Disciplinas_Outroid            varchar(255) not null,
  Disciplinas_Outroid            varchar(255) not null,
  constraint pk_Disciplinas_Disciplinas primary key (Disciplinas_Outroid, Disciplinas_Outroid))
;

create table periodo_Disciplinas (
  periodo_id                     varchar(255) not null,
  Disciplinas_Outroid            varchar(255) not null,
  constraint pk_periodo_Disciplinas primary key (periodo_id, Disciplinas_Outroid))
;
create sequence Disciplinas_seq;

create sequence grade_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;

alter table Disciplinas add constraint fk_Disciplinas_plano_de_curso_1 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_Disciplinas_plano_de_curso_1 on Disciplinas (plano_de_curso_id);
alter table periodo add constraint fk_periodo_plano_de_curso_2 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_periodo_plano_de_curso_2 on periodo (plano_de_curso_id);
alter table plano_de_curso add constraint fk_plano_de_curso_grade_3 foreign key (grade_id) references grade (id) on delete restrict on update restrict;
create index ix_plano_de_curso_grade_3 on plano_de_curso (grade_id);
alter table usuario add constraint fk_usuario_plano_4 foreign key (plano_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_usuario_plano_4 on usuario (plano_id);



alter table Disciplinas_Disciplinas add constraint fk_Disciplinas_Disciplinas_Di_01 foreign key (Disciplinas_Outroid) references Disciplinas (Outroid) on delete restrict on update restrict;

alter table Disciplinas_Disciplinas add constraint fk_Disciplinas_Disciplinas_Di_02 foreign key (Disciplinas_Outroid) references Disciplinas (Outroid) on delete restrict on update restrict;

alter table periodo_Disciplinas add constraint fk_periodo_Disciplinas_period_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_Disciplinas add constraint fk_periodo_Disciplinas_Discip_02 foreign key (Disciplinas_Outroid) references Disciplinas (Outroid) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Disciplinas;

drop table if exists Disciplinas_Disciplinas;

drop table if exists grade;

drop table if exists periodo;

drop table if exists periodo_Disciplinas;

drop table if exists plano_de_curso;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Disciplinas_seq;

drop sequence if exists grade_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

