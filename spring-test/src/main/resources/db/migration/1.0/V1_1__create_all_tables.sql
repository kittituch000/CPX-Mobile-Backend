drop table if exists user;
create table user(
    userId bigint not null,
    userName varchar(50) not null,
    userSuname varchar(50) not null,
    userAddress vachar(100) not null,
    primary key (itenId)

)