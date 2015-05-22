drop table Receipt

create table Receipt(
	receiptID   integer  not null,
	plotID integer not null,
      plotName nvarchar(50) not null,
      plotNumber integer not null,
      customerID integer not null,
      firstName  nvarchar(50) not null,
      lastName	 nvarchar(50) not null,
      address  nvarchar(50) not null,
      city  nvarchar(50) not null,
      roomCost  nvarchar(50) not null,
      customerPerct float not null,
      countryName nvarchar(50) not null,
      docDate  nvarchar(50) not null
      
      );