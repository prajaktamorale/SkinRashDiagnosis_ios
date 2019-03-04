'use strict';

angular.module('yapp').factory('APIService',
		['$http','$rootScope','$timeout',function($http, $rootScope, $timeout) {
					var service = {};

					service.getPatientList = function(callback) {
						$http({
							method : 'GET',
							url : 'patients'
						}).then(function(response) {
							// success callback
							callback(response);
						}, function(response) {
							alert(response);
						});
					};
					
					service.insertPatient = function(name, doctor, age,height, weight,  sex, bloodType, apptdate, callback) {
						var parameter = {
								 
								name : name,
								 doctor : doctor, 
								 age : age, 
								 weight : weight, 
								 height : height, 
								 sex : sex, 
								 bloodType : bloodType, 
								 apptdate : apptdate
						}
						
						//var patient = JSON.stringify(parameter);

						$http({
							method : 'POST',
							url : 'patients',
							data : parameter,
							contentType:"application/json"
						}).then(function(response) {
							// success callback
							callback(response);
						}, function(response) {
							alert(response);
						});
					};
					
					return service;
				} ]);