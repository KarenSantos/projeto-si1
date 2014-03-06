# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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


create table disciplina_preRequisito (
  disciplina                     varchar(255) not null,
  preRequisito                   varchar(255) not null,
  constraint pk_disciplina_preRequisito primary key (disciplina, preRequisito))
;

create table periodo_disciplina (
  periodo                        varchar(255) not null,
  disciplina                     varchar(255) not null,
  constraint pk_periodo_disciplina primary key (periodo, disciplina))
;
create sequence disciplina_seq;

create sequence periodo_seq;




alter table disciplina_preRequisito add constraint fk_disciplina_preRequisito_di_01 foreign key (disciplina) references disciplina (id) on delete restrict on update restrict;

alter table disciplina_preRequisito add constraint fk_disciplina_preRequisito_di_02 foreign key (preRequisito) references disciplina (id) on delete restrict on update restrict;

alter table periodo_disciplina add constraint fk_periodo_disciplina_periodo_01 foreign key (periodo) references periodo (id) on delete restrict on update restrict;

alter table periodo_disciplina add constraint fk_periodo_disciplina_discipl_02 foreign key (disciplina) references disciplina (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists disciplina;

drop table if exists disciplina_preRequisito;

drop table if exists periodo;

drop table if exists periodo_disciplina;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

