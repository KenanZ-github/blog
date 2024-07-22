create table Author(
 id INTEGER auto_increment primary key,
 name varchar(100) not null,
 user_name varchar(100) not null,
 email varchar (100) not null
);
create table Post (
    id int auto_increment primary key,
    title varchar (100) not null,
    content text not null,
    published_on timestamp not null,
    updated_on timestamp,
    author INTEGER,
    foreign key (author) references Author(id)
);
create table Comment (
    post int,
    title varchar (100) not null,
    content text not null,
    published_on timestamp not null,
    updated_on timestamp,
    foreign key (post) references Post(id)
);

