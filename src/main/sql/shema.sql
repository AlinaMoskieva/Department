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
    date DATE ,
    FOREIGN KEY (userId) REFERENCES user(id)
)