create table Contract (
	contractID integer identity primary key,
	customerID integer not null,
	plotID integer not null,
	customerPercentage float not null,
	active integer not null --yes/no
);