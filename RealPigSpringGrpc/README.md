create type part_names as enum ('HEAD', 'RIBS', 'LEG', 'BOTTOM');

create table pig
(
id     serial primary key,
weight numeric(4, 2)
);

create table product
(
id   serial primary key,
name varchar(25)
);

create table part
(
id        serial primary key,
weight    numeric(4, 2) not null,
pigid     integer       not null references pig,
productid integer  references product,
name      part_names,
trayid    varchar(100)
);
