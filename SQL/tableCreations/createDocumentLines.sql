create table DocumentLines (
	docNumber integer primary key,
	NA integer not null,
	serviceKeyID integer not null,
	descriptions text not null,
	amount float not null
);