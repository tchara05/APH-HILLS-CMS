drop table Customer;

create table Customer (
	customerID int identity(1,1) primary key,
	firstName varchar (50),
	lastName varchar (50),
	address varchar (50),
	primaryEmail varchar (50),
	secondaryEmail varchar (50),
	countryID int,
	city varchar (50),
	zipCode int,
	bussinesPhone int,
	mobilePhone int,
	contactPhone int,
	fax int,
	closeAccount int default 0, --yes/no
	informationMaterial int default 0, --yes/no
	note text,
	CONSTRAINT checkAcount CHECK (closeAccount= 1 or closeAccount = 0),
	CONSTRAINT informationMaterial CHECK (informationMaterial =1 or InformationMaterial=0)
);

