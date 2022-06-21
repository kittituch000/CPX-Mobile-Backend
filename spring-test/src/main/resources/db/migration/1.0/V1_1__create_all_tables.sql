drop table if exists Users;
create table Users(
    userId bigint not null NOT NULL,
    userName varchar(50 ) not null,
    userSurname varchar(50 ) not null,
    primary key (userId)

)
