'use strict';

angular.module('yapp').factory('AuthenticationService',
		['$http','$rootScope','$timeout',function($http, $rootScope, $timeout) {
					var service = {};

					service.Login = function( username, password, callback) {
						
						$http({
							method : 'POST',
							url : 'login?username=' + username + "&password=" + password
						}).then(function(response) {
							// success callback
							callback(response);
						}, function(response) {
							// failure callback
						});
					
					};
					 
					
					
					service.SetCredentials = function(server, username,password) {
						$rootScope.globals = {
							currentUser : {
								username : username,
								password: password
							}
						};
					};

					service.ClearCredentials = function() {
						$rootScope.globals = {};

					}; 

					return service;
				} ]);