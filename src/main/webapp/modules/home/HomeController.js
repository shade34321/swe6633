'use strict';

angular.module('spt.home').controller('HomeController', [
    '$scope',
    'toaster',
    function($scope,
             toaster) {
        $scope.confirm = function () {
            toaster.pop('success', "Confirm", "We got it");
        }
    }
]);