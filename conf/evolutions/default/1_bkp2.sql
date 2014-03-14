# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table disciplina (
  id                        varchar(255) not null,
  nome                      varchar(255) not null,
  periodo_atual_id          varchar(255),
  plano_atual_id            varchar(255),
  creditos                  integer,
  periodo_sugerido          integer,
  dificuldade               integer,
  alocada_corretamente      boolean,
  constraint uq_disciplina_nome unique (nome),
  constraint pk_disciplina primary key (id))
;

create table periodo (
  id                        varchar(255) not null,
  plano_de_curso_id         varchar(255) not null,
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
  minimo_de_creditos        integer,
  periodos_base             integer,
  constraint pk_plano_de_curso primary key (id))
;

create table usuario (
  email                     varchar(255) not null,
  nome                      varchar(255),
  password                  varchar(255),
  plano_id                  varchar(255),
  constraint pk_usuario primary key (email))
;


create table disciplina_preRequisito (
  di_disciplina                  varchar(255) not null,
  pr_preRequisito                varchar(255) not null,
  constraint pk_disciplina_preRequisito primary key (di_disciplina, pr_preRequisito))
;

create table periodo_disciplina (
  periodo_id                     varchar(255) not null,
  disciplina_id                  varchar(255) not null,
  constraint pk_periodo_disciplina primary key (periodo_id, disciplina_id))
;
create sequence disciplina_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence usuario_seq;

alter table disciplina add constraint fk_disciplina_periodoAtual_1 foreign key (periodo_atual_id) references periodo (id) on delete restrict on update restrict;
create index ix_disciplina_periodoAtual_1 on disciplina (periodo_atual_id);
alter table disciplina add constraint fk_disciplina_planoAtual_2 foreign key (plano_atual_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_disciplina_planoAtual_2 on disciplina (plano_atual_id);
alter table periodo add constraint fk_periodo_plano_de_curso_3 foreign key (plano_de_curso_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_periodo_plano_de_curso_3 on periodo (plano_de_curso_id);
alter table usuario add constraint fk_usuario_plano_4 foreign key (plano_id) references plano_de_curso (id) on delete restrict on update restrict;
create index ix_usuario_plano_4 on usuario (plano_id);



alter table disciplina_preRequisito add constraint fk_disciplina_preRequisito_di_01 foreign key (di_disciplina) references disciplina (id) on delete restrict on update restrict;

alter table disciplina_preRequisito add constraint fk_disciplina_preRequisito_di_02 foreign key (pr_preRequisito) references disciplina (id) on delete restrict on update restrict;

alter table periodo_disciplina add constraint fk_periodo_disciplina_periodo_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_disciplina add constraint fk_periodo_disciplina_discipl_02 foreign key (disciplina_id) references disciplina (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists disciplina;

drop table if exists disciplina_preRequisito;

drop table if exists periodo;

drop table if exists periodo_disciplina;

drop table if exists plano_de_curso;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists usuario_seq;

