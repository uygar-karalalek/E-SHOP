-- auto-generated definition
create schema IF NOT EXISTS `e-shop` collate utf8mb4_0900_ai_ci;

create table `e-shop`.product
(
    id          bigint auto_increment primary key,
    description varchar(255) null,
    price       double       null,
    title       varchar(255) null
);

create table `e-shop`.user
(
    id       bigint auto_increment
        primary key,
    address  varchar(255) null,
    email    varchar(255) null,
    guest    bit          null,
    name     varchar(255) null,
    password varchar(255) null,
    surname  varchar(255) null
);

create table `e-shop`.`order`
(
    id         bigint auto_increment
        primary key,
    date_added datetime(6) null,
    status     int         null,
    fk_user    bigint      null,
    constraint FKqvto2vd3o6ho7yqvrl8k56olk
        foreign key (fk_user) references `e-shop`.user (id)
);

create table `e-shop`.order_product
(
    fk_order   bigint not null,
    fk_product bigint not null,
    quantity   int    null,  primary key (fk_order, fk_product),
    constraint FK1uoek885ds1bye9ln99ot4wxx
        foreign key (fk_product) references `e-shop`.product (id),
    constraint FKb8buptsi8lfly52ujnjsom21g
        foreign key (fk_order) references `e-shop`.`order` (id)
);

create table `e-shop`.shopping_card
(
    user_id bigint not null
        primary key,
    constraint FK1w1cxlj10j3rcbey3rnq8d4dd
        foreign key (user_id) references `e-shop`.user (id)
);

create table `e-shop`.card_item
(
    fk_card    bigint      not null,
    fk_product bigint      not null,
    date_added datetime(6) null,
    quantity   int         null,
        primary key (fk_card, fk_product),
    constraint FK7sn9ojgf6p04nu2u6nk08hv04
        foreign key (fk_card) references `e-shop`.shopping_card (user_id),
    constraint FKq8c219qafv3m6m0fe5bi8av3n
        foreign key (fk_product) references `e-shop`.product (id)
);