'use strict';

angular.module('spt.member').controller('CreateMemberController', [
    'MemberService',
    '$scope',
    'toaster',
    function(MemberService, $scope, toaster) {
        $scope.createMember = function() {
            $scope.member.role = $scope.isManager ? 'MANAGER' : 'NONE';

            MemberService.save($scope.member, function() {
                toaster.pop('success', "Success", "Member created successfully");
            });
        };
    }
]).factory('MemberService', [
    '$resource',
    function($resource) {
        return $resource('api/member');
    }
]);