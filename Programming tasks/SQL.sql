CREATE TABLE 'Person' (ID INTEGER, 'FirstName' VARCHAR(40), 'LastName' VARCHAR(40), CONSTRAINT PK_Person PRIMARY KEY (ID));
CREATE TABLE 'Email' (ID INTEGER, 'Email' VARCHAR, 'PersonID' INT, CONSTRAINT PK_Email PRIMARY KEY (ID), 
																										CONSTRAINT FK_Person FOREIGN KEY (PersonID) REFERENCES Person(ID));
CREATE TABLE 'Address' (ID INTEGER, 'Address' VARCHAR(100), 'City' VARCHAR(30), 'County' VARCHAR(30), 'Postal' VARCHAR(7), 'PersonID' INT, CONSTRAINT PK_Address PRIMARY KEY (ID), 
																										CONSTRAINT FK_Person FOREIGN KEY (PersonID) REFERENCES Person(ID));
CREATE TABLE 'Phone' (ID INTEGER, 'PhoneNumber' INT(12), 'PersonID' INT, CONSTRAINT PK_Number PRIMARY KEY (ID),
																										CONSTRAINT FK_Number FOREIGN KEY (PersonID) REFERENCES Person(ID));

INSERT INTO Person(FirstName, LastName) SELECT first_name, last_name FROM Import;	
INSERT INTO Email(Email, PersonID) SELECT Email, ID FROM Import;
INSERT INTO Address(Address, City, County, Postal, PersonID) SELECT Address, City, County, Postal, ID FROM Import;
INSERT INTO Phone(PhoneNumber, PersonID) SELECT phone1, ID FROM Import;
INSERT INTO Phone(PhoneNumber, PersonID) SELECT phone2, ID  FROM Import;

SELECT * FROM Address WHERE (Address, City, County, Postal) IN ( SELECT Address, City, County, Postal  FROM Address GROUP BY Address, City, County, Postal HAVING COUNT() > 3) ORDER BY Postal;