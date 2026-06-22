create table b (
    id int primary key
);

create table a(
    id int primary key,
    b_id int,
    foreign key (b_id) references b(id)
);