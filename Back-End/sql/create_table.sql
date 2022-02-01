create table if not exists `e-shop`.product
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    price       double       null,
    title       varchar(255) null
);

create table if not exists `e-shop`.shopping_card
(
    id bigint auto_increment
        primary key
);

create table if not exists `e-shop`.card_item
(
    card_id    bigint      not null,
    fk_product bigint      not null,
    date_added datetime(6) null,
    quantity   int         null,
    fk_card    bigint      null,
    primary key (card_id, fk_product),
    foreign key (fk_card) references `e-shop`.shopping_card (id),
    foreign key (fk_product) references `e-shop`.product (id)
);

create table if not exists `e-shop`.user
(
    id       bigint auto_increment
        primary key,
    address  varchar(255) null,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    surname  varchar(255) null,
    fk_card  bigint       null,
    foreign key (fk_card) references `e-shop`.shopping_card (id)
);

create table if not exists `e-shop`.`order`
(
    id      bigint auto_increment
        primary key,
    status  bit    null,
    fk_user bigint null,
    foreign key (fk_user) references `e-shop`.user (id)
);

create table if not exists `e-shop`.order_product
(
    id         bigint auto_increment
        primary key,
    quantity   int    null,
    fk_product bigint null,
    fk_order   bigint null,
    foreign key (fk_product) references `e-shop`.product (id),
    foreign key (fk_order) references `e-shop`.`order` (id)
);

