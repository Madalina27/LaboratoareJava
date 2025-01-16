drop table if exists masini;
create table masini (nr_inmatriculare char(7) not null primary key, marca varchar(30) not null, an_fabricatie year, culoare varchar(30), nr_kilometri integer);

insert into masini values ('TM07ESY','Mercedes', 2007, 'mov', 3000);
insert into masini values ('TM34ESF', 'BMW', 2020, 'gri', 200000);
insert into masini values ('TM12EEE', 'Opel', 2010, 'negru', 2340);
insert into masini values ('TM34DER', 'Audi', 2023, 'alb', 220000);
insert into masini values ('TM78GHY', 'Mercedes',2022, 'auriu', 5000);