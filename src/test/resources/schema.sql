create table rank (
       keyword varchar(255) not null,
        count integer,
        primary key (keyword)
);

insert into rank (keyword, count) values ('오렌지', 3);
insert into rank (keyword, count) values ('감자', 2);