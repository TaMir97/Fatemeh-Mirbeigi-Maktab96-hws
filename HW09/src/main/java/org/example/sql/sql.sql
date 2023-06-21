create database online_shop;

create table users
(
    userID    bigserial primary key,
    firstname varchar(50) not null,
    lastname varchar(50) not null ,
    user_name varchar(50) unique not null,
    password  varchar(50)        not null,
    email     varchar unique     not null
);

create table categories
(
    category_name varchar unique not null
);



create table cart
(
    cartID bigserial primary key,
    userID bigint references users (userID),
    paycheck bigint not null,
    total_items int not null,
);

create table cart_items
(
    cartID     bigint references cart (cartID),
    productID  bigint references products (productID)
);