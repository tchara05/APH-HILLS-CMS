


drop table Contract;


create table Contract (
	contractID integer identity primary key,
	customerID integer not null,
	plotID integer not null,
	customerPercentage float not null,
	active integer not null,
	CONSTRAINT bool CHECK (active = 1 or docStatus = 0)
);