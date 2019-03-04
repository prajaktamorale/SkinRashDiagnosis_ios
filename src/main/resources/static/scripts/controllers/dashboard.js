'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('DashboardCtrl', function($scope, $state, $rootScope, APIService) {
	  
    $scope.$state = $state;
    
	APIService.getPatientList(function(response) {
        if(response.data) {
        	$scope.instances = response.data;	
	    } else {
	        $scope.error = response.message;
	        $scope.dataLoading = false;
	        alert("Patients not found");
	    }
    });
	
	$scope.insertPatient = function (instance) {
        $scope.dataLoading = true;
        APIService.insertPatient(instance.name, instance.doctor, instance.age, instance.height, instance.weight, instance.sex, instance.bloodType, instance.apptdate, function(response) {
            if(response.data) {
            	alert(response.data);
        } else {
            $scope.error = response.message;
            $scope.dataLoading = false;
            alert("Instance not created");
        }
    });
    };
    
    $scope.menuItems = [];
    angular.forEach($state.get(), function (item) {
        if (item.data && item.data.visible) {
            $scope.menuItems.push({name: item.name, text: item.data.text});
        }
    });
  });
