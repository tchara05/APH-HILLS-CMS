create table Property (
	plotID integer identity primary key,
	plotNumber integer not null,
	plotName nvarchar(50) not null,
	propertyClassNo integer not null,
	parcelNo integer not null,
	landUse integer not null,
	percentage float not null,
	plots integer not null,
	details text not null,
	propertyDelivered integer not null, --yes/no
	rentalGuarantee integer not null, --yes/no
	committedProperty integer not null, --yes/no
	rentalPlan integer not null, --yes/no
	propertyStatus integer not null,
	numberOfFloors integer not null,
	numberOfBedrooms integer not null,
	numberOfBathrooms integer not null,
	deedNumber integer not null,
	titleDeed integer not null, --yes/no
	poolProperty integer not null, --yes/no
	parking integer not null, --yes/no
	garden integer not null, --yes/no
	centralHeading integer not null, --yes/no
	basement integer not null, --yes/no
	airCondition integer not null, --yes/no
	keysID integer not null --yes/no
);