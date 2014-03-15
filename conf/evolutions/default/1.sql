# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Disciplina (
  id                        bigint not null,
  plano_de_curso_id         bigint not null,
  nome                      varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
  constraint pk_Disciplina primary key (id))
;

create table periodo (
  id                        varchar(255) not null,
  plano_de_curso_id         bigint not null,
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
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  id                        bigint not null,
  email                     varchar(255),
  nome                      varchar(255),
  password                  varchar(255),
  constraint pk_usuario primary key (id))
;


create table periodo_Disciplina (
  periodo_id                     varchar(255) not null,
  Disciplina_id                  bigint not null,
  constraint pk_periodo_Disciplina primary key (periodo_id, Disciplina_id))
;
create sequence Disciplina_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;

alter table Disciplina add constraint fk_Disciplina_plano_de_curso_1 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_Disciplina_plano_de_curso_1 on Disciplina (plano_de_curso_id);
alter table periodo add constraint fk_periodo_plano_de_curso_2 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_periodo_plano_de_curso_2 on periodo (plano_de_curso_id);



alter table periodo_Disciplina add constraint fk_periodo_Disciplina_periodo_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_Disciplina add constraint fk_periodo_Disciplina_Discipl_02 foreign key (Disciplina_id) references Disciplina (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Disciplina;

drop table if exists periodo;

drop table if exists periodo_Disciplina;

drop table if exists plano_de_curso;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

