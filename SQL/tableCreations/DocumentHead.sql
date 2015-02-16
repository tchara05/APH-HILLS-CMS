
drop talbe DocumentHead;

create table DocumentHead(
	documentID integer primary key,
	customerID integer not null,
	docType char not null,
	exportDate int not null,
	issuedBy integer not null,
	docStatus integer not null, -- true/false
	CONSTRAINT bool CHECK (docStatus = 1 or docStatus = 0)

);
