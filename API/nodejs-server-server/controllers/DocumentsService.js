'use strict';

exports.documentDocumentIdAdditionalGET = function(args, res, next) {
  /**
   * parameters expected in the args:
  * documentId (BigDecimal)
  **/
    var examples = {};
  examples['application/json'] = "";
  if(Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  }
  else {
    res.end();
  }
  
}

exports.documentDocumentIdAdditionalPOST = function(args, res, next) {
  /**
   * parameters expected in the args:
  * documentId (BigDecimal)
  * body (Participant)
  **/
  // no response value expected for this operation
  res.end();
}

exports.documentIdGET = function(args, res, next) {
  /**
   * parameters expected in the args:
  * id (BigDecimal)
  **/
    var examples = {};
  examples['application/json'] = {
  "date" : "aeiou",
  "theTypeLaborArbitrators" : "aeiou",
  "fullName" : "aeiou",
  "document_id" : 1.3579000000000001069366817318950779736042022705078125,
  "mailingAddressOfTheApplicant" : "aeiou",
  "legalStatusOfTheApplicant" : "aeiou",
  "preferredLocation" : "aeiou",
  "denominationOfApplicant" : "aeiou",
  "idUser" : 1.3579000000000001069366817318950779736042022705078125,
  "emailAddress" : "aeiou",
  "positionApplicant" : "aeiou",
  "timeOfThePreparationOfLaborArbitrators" : "2000-01-23T04:56:07.000+0000",
  "formOfThePreparationOfLaborArbitrators" : "aeiou",
  "contactPhoneNumber" : "aeiou"
};
  if(Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  }
  else {
    res.end();
  }
  
}

exports.documentsGET = function(args, res, next) {
  /**
   * parameters expected in the args:
  **/
    var examples = {};
  examples['application/json'] = "";
  if(Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  }
  else {
    res.end();
  }
  
}

exports.documentsPOST = function(args, res, next) {
  /**
   * parameters expected in the args:
  * body (Document)
  **/
  // no response value expected for this operation
  res.end();
}

