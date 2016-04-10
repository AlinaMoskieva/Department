'use strict';

var url = require('url');


var User = require('./UserService');


module.exports.loginGET = function loginGET (req, res, next) {
  User.loginGET(req.swagger.params, res, next);
};

module.exports.logoutGET = function logoutGET (req, res, next) {
  User.logoutGET(req.swagger.params, res, next);
};

module.exports.profilePUT = function profilePUT (req, res, next) {
  User.profilePUT(req.swagger.params, res, next);
};

module.exports.signinPOST = function signinPOST (req, res, next) {
  User.signinPOST(req.swagger.params, res, next);
};
