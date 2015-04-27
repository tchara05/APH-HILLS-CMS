
drop table Service;

create table Service (
	keyID int,
	specificKey int,
	checkIN datetime,
	checkOUT datetime,
	details text,
	SecurityPerson varchar (50),
	pickUpPerson varchar (50)

)