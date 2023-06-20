create database book_store;


create table authors
(
    author_id serial primary key,
    firstname varchar not null,
    lastname  varchar not null,
    age       int     not null
);

create table books
(
    book_id      serial primary key,
    title        varchar not null,
    release_year int,
    author_id    int,
    foreign key (author_id) references authors (author_id)
);
