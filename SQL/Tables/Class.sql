
drop table Class;

create table Class (
	propertyClassNo int identity(1,1) primary key,
	className varchar (50),
);


insert into Class  values('Luxury Villa');
insert into Class values ('Junior Villa');
insert into Class values ('Apartment');
insert into Class values ('Plot');