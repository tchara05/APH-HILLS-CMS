create table Customer (
	customerID int identity(1,1) primary key,
	firstName varchar (50),
	lastName varchar (50),
	primaryEmail varchar (50),
	SecontaryEmail varchar (50),
	countryID int,
	city varchar (50),
	zipCode int,
	bussinesPhone int,
	mobilePhone int,
	contactPhone int,
	fax int,
	closeAccount int,
	informationMaterial int,
	note text

);
