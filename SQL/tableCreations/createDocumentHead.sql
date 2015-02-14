

create table DocumentHead(
	documentID integer primary key,
	docType char not null,
	exportDate int not null,
	issuedBy integer not null,
	docStatus integer not null,
	CONSTRAINT bool CHECK (docStatus = 1 or docStatus = 0)

);
