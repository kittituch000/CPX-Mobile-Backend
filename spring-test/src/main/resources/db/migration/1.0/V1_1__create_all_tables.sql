drop table if exists Users;
create table Users(
    userId bigint not null NOT NULL,
    userName varchar(50 ) IS NOT NULL,
    userSurname varchar(50 ) IS NOT NULL,
    primary key (userId)

)
