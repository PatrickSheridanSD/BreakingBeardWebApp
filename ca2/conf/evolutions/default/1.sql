# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact1 (
  id                        bigint not null,
  email                     varchar(255),
  name                      varchar(255),
  phone_number              varchar(255),
  town                      varchar(255),
  country                   varchar(255),
  constraint pk_contact1 primary key (id))
;

create table product (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  category                  varchar(255),
  stock                     integer,
  price                     double,
  constraint pk_product primary key (id))
;

create sequence contact1_seq;

create sequence product_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists contact1;

drop table if exists product;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists contact1_seq;

drop sequence if exists product_seq;

