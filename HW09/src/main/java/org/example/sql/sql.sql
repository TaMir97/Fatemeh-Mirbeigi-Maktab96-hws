create database online_shop;

create table users
(
    userID    bigserial primary key,
    firstname varchar(50)        not null,
    lastname  varchar(50)        not null,
    user_name varchar(50) unique not null,
    password  varchar(50)        not null,
    email     varchar unique     not null
);

create table cart
(
    cartID      bigserial primary key,
    userID      bigint,
    foreign key (userID) references users (userID),
    paycheck    bigint not null,
    total_items int    not null
);

create table categories
(
    category_name varchar unique not null
);

create table "types"
(
    type_name varchar unique not null
);

create table products
(
    productID     bigserial primary key,
    category_name varchar not null,
    foreign key (category_name) references categories (category_name),
    type_name     varchar not null,
    foreign key (type_name) references "types" (type_name),
    price         bigint  not null,
    availability  int     not null
);

create table cart_items
(
    cartID    bigint,
    foreign key (cartID) references cart (cartID),
    productID bigint,
    foreign key (productID) references products (productID)
);