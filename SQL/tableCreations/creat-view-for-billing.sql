
DROP VIEW COSTS

CREATE VIEW COSTS AS
SELECT P.plotID, P.plotName, P.plotNumber, C.customerID, C.firstName, C.lastName, C.address, C.city, R.roomCost, CR.customerPerct, CNT.countryName
FROM Rooms R, Contract CR, Customer C, Property P, Country CNT
WHERE R.propertyID = CR.plotID and CR.customerID = C.customerID and P.plotID = CR.plotID AND CR.active=1 and C.countryID = CNT.countryID
