
create table Country (
		countryID  integer identity primary key,
		countryName nvarchar(50) unique not null
);

