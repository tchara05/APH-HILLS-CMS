drop table PropertyStatus;

create table PropertyStatus (
	statusID integer identity(1,1) primary key,
	propertyStatus nvarchar(50) not null,
);