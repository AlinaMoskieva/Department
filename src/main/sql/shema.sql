CREATE TABLE document (
  id IDENTITY(1,1) PRIMARY KEY,
  denominationOfApplicant VARCHAR(100),
  legalStatusOfTheApplicant VARCHAR(100),
  theTypeLaborArbitrators VARCHAR(100),
  formOfThePreparationOfLaborArbitrators VARCHAR(100),
  timeOfThePreparationOfLaborArbitrators VARCHAR(100),
  preferredLocation VARCHAR(100),
  mailingAddressOfTheApplicant VARCHAR(100),
  contactPhoneNumbers VARCHAR(100),
  emailAddress VARCHAR(100),
  positionApplicant VARCHAR(100),
  fullName VARCHAR(100),
  date DATE ,

  FOREIGN KEY (userId) REFERENCES user(id)
)

CREATE TABLE user (
  id IDENTITY(1,1) PRIMARY KEY,
  userName VARCHAR (100),
  email VARCHAR (100),
  city VARCHAR (100),
  age VARCHAR (100),
  gender VARCHAR (100),
  passportData VARCHAR (100),
  snils int
)
CREATE TABLE participant (
  id IDENTITY(1,1) PRIMARY KEY,
  fullName VARCHAR (100),
  education VARCHAR (100),
  placeOfWork VARCHAR (100),
  positionAtWork VARCHAR (100),
  FOREIGN KEY (documentId) REFERENCES document(id)
)