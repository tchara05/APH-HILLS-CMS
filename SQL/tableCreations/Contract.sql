


drop table Contract;


create table Contract (
	contractID integer primary key,
	customerID integer not null,
	plotID integer not null,
	customerPerct float not null,
	active integer not null by default 1,
	CONSTRAINT activeCheck CHECK (active = 1 or active = 0)
);