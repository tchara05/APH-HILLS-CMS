
drop table PaumentMethod;


create PaymentMethod (
	methodPayment integer (1,1) primary key,
	methodName nvarchar(50) not null
);