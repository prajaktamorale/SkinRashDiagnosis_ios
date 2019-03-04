/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description # MainCtrl Controller of yapp
 */
angular.module('yapp').controller('LoginCtrl',  ['$scope', '$rootScope', '$location', 'AuthenticationService',
	    function ($scope, $rootScope, $location, AuthenticationService) {
    // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.submit = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login( $scope.username, $scope.password, function(response) {
                if(response) {
                    AuthenticationService.SetCredentials( $scope.username, $scope.password);
                	$location.path('/dashboard');
            } else {
                $scope.error = response.message;
                $scope.dataLoading = false;
                alert(response.message);
            }
        });
    };
  
 
}]);
 