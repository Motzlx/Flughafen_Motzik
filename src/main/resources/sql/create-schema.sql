create sequence country_seq start with 1 increment by 50;
create sequence flug_seq start with 1 increment by 50;
create sequence flughafen_seq start with 1 increment by 50;
create sequence flugzeug_seq start with 1 increment by 50;
create sequence passagier_seq start with 1 increment by 50;
create sequence pilot_seq start with 1 increment by 50;

create table country (
                         id bigint not null,
                         country_name varchar(255),
                         iso2code varchar(255),
                         primary key (id)
);

create table flug (
                      id bigint not null,
                      abflug_zeit timestamp(6),
                      ankunfts_zeit timestamp(6),
                      destination_flughafen_id bigint,
                      flugzeug_id bigint,
                      source_flughafen_id bigint,
                      primary key (id)
);

create table flug_passagier_list (
                                     flug_id bigint not null,
                                     passagier_list_id bigint not null
);

create table flughafen (
                           id bigint not null,
                           flughafen_name varchar(255),
                           country_id bigint,
                           primary key (id)
);

create table flughafen_flugzeug (
                                    id bigint not null,
                                    flugzeug_id bigint,
                                    assignment_ts timestamp(6)
);

create table flugzeug (
                          id bigint not null,
                          flugzeug_type varchar(255),
                          fuel_in_litres integer,
                          num_of_passangers integer,
                          current_flughafen_id bigint,
                          primary key (id)
);

create table flugzeug_geflogene_fluege (
                                           flugzeug_id bigint not null,
                                           geflogene_fluege_id bigint not null
);

create table passagier (
                           id bigint not null,
                           first_name varchar(32),
                           last_name varchar(64),
                           user_name varchar(255),
                           country_id bigint,
                           primary key (id)
);

create table passagier_fluege (
                                  passagier_id bigint not null,
                                  fluege_id bigint not null
);

create table pilot (
                       id bigint not null,
                       first_name varchar(32),
                       last_name varchar(64),
                       user_name varchar(255),
                       no_of_flights integer,
                       year_of_graduation timestamp(6),
                       primary key (id)
);

alter table if exists flug_passagier_list
    add constraint UK_cvgm67yrxtf9y05fkw08ejq0g unique (passagier_list_id);

alter table if exists flugzeug_geflogene_fluege
    add constraint UK_in67v0yh9jcuxcx0p2utwiktd unique (geflogene_fluege_id);

alter table if exists passagier_fluege
    add constraint UK_f330jrk46fm1vl3aj9c3urkt2 unique (fluege_id);

alter table if exists flug
    add constraint FKouss4olk14huxklxb3xcbikh2
        foreign key (destination_flughafen_id)
            references flughafen;

alter table if exists flug
    add constraint FKk6yx2uqn3leloojy13524stb8
        foreign key (flugzeug_id)
            references flugzeug;

alter table if exists flug
    add constraint FKlrjk1k96j1b4b5030b99ojpo8
        foreign key (source_flughafen_id)
            references flughafen;

alter table if exists flug_passagier_list
    add constraint FKi8y6tq3mlvemaitr3irmtn6jb
        foreign key (passagier_list_id)
            references passagier;

alter table if exists flug_passagier_list
    add constraint FKhikb4ty4lfjrm8u3eqsw1wpiw
        foreign key (flug_id)
            references flug;

alter table if exists flughafen
    add constraint FKs2paant0cx15ri563atyocd10
        foreign key (country_id)
            references country;

alter table if exists flughafen_flugzeug
    add constraint FK_flughafen_2_flugzeug
        foreign key (flugzeug_id)
            references flugzeug;

alter table if exists flughafen_flugzeug
    add constraint FK_flughafen_2_flugzeug1
        foreign key (id)
            references flughafen;

alter table if exists flugzeug
    add constraint FK_flugzeug_2_flughafen
        foreign key (current_flughafen_id)
            references flughafen;

alter table if exists flugzeug_geflogene_fluege
    add constraint FK9dh7ws3e5q8fsoirhh4uxh1p7
        foreign key (geflogene_fluege_id)
            references flug;

alter table if exists flugzeug_geflogene_fluege
    add constraint FKi262hfh32ep9ff9fic3k623gm
        foreign key (flugzeug_id)
            references flugzeug;

alter table if exists passagier
    add constraint FKqsbpoq3a4xpc9wkradvj0jxb
        foreign key (country_id)
            references country;

alter table if exists passagier_fluege
    add constraint FK6y2b24qvpnatjpraf1b2f4rfq
        foreign key (fluege_id)
            references flug;

alter table if exists passagier_fluege
    add constraint FKlu7q95hu38s0iq4y7fegvdpfc
        foreign key (passagier_id)
            references passagier;
