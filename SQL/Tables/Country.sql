

drop table Country;

create table Country (
		countryID  integer identity(1,1) primary key,
		countryName nvarchar(50) unique not null
);

