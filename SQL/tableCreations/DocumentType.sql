
drop table DocumentType;


create table DocumentType (
	docType char primary key,
	docName nvarchar(20) not null,
	docNumberStart integer

);