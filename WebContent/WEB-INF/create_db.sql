drop database dt354jdbc;
create database dt354jdbc;
use dt354jdbc;
create table users(
	firstName varchar(25) NOT NULL,
    lastName varchar(25) NOT NULL,
    email varchar(255) NOT NULL UNIQUE ,
    passw varchar(25) NOT NULL,
    gender varchar(10) NOT NULL,
    PRIMARY KEY(email)
);

create table friends(
	userEmail varchar(255) NOT NULL, 
	friendEmail varchar(255) NOT NULL,
	foreign key (userEmail) references users(email),
	foreign key (friendEmail) references users(email)
);

create table post(
	id int NOT NULL auto_increment,
    sender varchar(255),
    receiver varchar(255),
    message varchar(255),
	primary key(id),
    foreign key (sender) references users(email),
    foreign key (receiver) references users(email)
);