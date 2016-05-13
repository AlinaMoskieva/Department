CREATE TABLE document (
  id SERIAL PRIMARY KEY,
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
  date DATE,
  userId INT,

  FOREIGN KEY (userId) REFERENCES users(id)
)

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  userName VARCHAR (100),
  email VARCHAR (100),
  city VARCHAR (100),
  age VARCHAR (100),
  gender VARCHAR (100),
  passportData VARCHAR (100),
  snils VARCHAR (100)
)
CREATE TABLE participant (
  id SERIAL PRIMARY KEY,
  fullName VARCHAR (100),
  education VARCHAR (100),
  placeOfWork VARCHAR (100),
  positionAtWork VARCHAR (100),
  documentId INT,
  FOREIGN KEY (documentId) REFERENCES document(id)
)

CREATE TABLE tokens (
  userId int,
  token VARCHAR (100),

  FOREIGN KEY (userId) REFERENCES  users(id)
)

CREATE TABLE passwords(
  userId int,
  login VARCHAR (100),
  password VARCHAR (100),

  FOREIGN  KEY (userId) REFERENCES users(id)
)