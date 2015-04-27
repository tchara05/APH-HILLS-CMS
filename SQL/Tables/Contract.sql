drop table Contract;

create table Contract (
	contractID integer not null,
	customerID integer not null,
	plotID integer not null,
	customerPerct integer not null,
	active integer not null by default 1,
	CONSTRAINT activeContrack CHECK (active = 1 or active = 0),
	CONSTRAINT PK_Contract PRIMARY KEY (contractID, customerID, plotID)
);