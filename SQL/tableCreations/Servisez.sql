
drop table Service;

create table Service (
	keyID int  primary key,
	specificKey int primary key,
	checkIN datetime,
	checkOUT datetime,
	details text,
	SecurityPerson varchar (50),
	pickUpPerson varchar (50)

)