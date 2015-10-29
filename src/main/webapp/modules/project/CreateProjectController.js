'use strict';

angular.module('spt.project').controller('CreateProjectController', [
    '$resource',
    '$scope',
    'MemberService',
    'toaster',
    function($resource,
             $scope,
             MemberService,
             toaster) {
        var projectService = $resource('api/project');

        $scope.project = {
            members: [],
            risks: []
        };

        $scope.create = function() {
            var isValid = true;
            if (!$scope.project.manager) {
                toaster.pop('error', "Validation Error", "Project Manager must be assigned");
                isValid = false;
            }

            if (!$scope.project.name) {
                toaster.pop('error', "Validation Error", "Project Name cannot be empty");
                isValid = false;
            }

            if (!$scope.project.description) {
                toaster.pop('error', "Validation Error", "Project Description cannot be empty");
                isValid = false;
            }

            if (isValid) {
                projectService.save($scope.project, function() {
                    toaster.pop('success', "Success", "Project created successfully");
                });
            }
        };

        $scope.availableMembers = MemberService.query();

        $scope.assignMember = function(member) {

            var indexToRemove = $scope.availableMembers.indexOf(member);
            $scope.project.members.push(member);

            if (indexToRemove !== -1) {
                $scope.availableMembers.splice(indexToRemove, 1);
            }
        };

        $scope.unassignMember = function(member) {
            var indexToRemove = $scope.project.members.indexOf(member);
            $scope.availableMembers.push(member);

            if (indexToRemove !== -1) {
                $scope.project.members.splice(indexToRemove, 1);
            }
        };

        $scope.addRisk = function() {
            if (!$scope.isAddingRisk) {
                $scope.isAddingRisk = true;
                return;
            }

            if (!$scope.riskToAdd.description) {
                toaster.pop('error', "Validation Error", "Risk Description cannot be empty");
            }

            if (!$scope.riskToAdd.status) {
                toaster.pop('error', "Validation Error", "A Risk Status must be selected");
            }

            $scope.project.risks.push($scope.riskToAdd);
            $scope.riskToAdd = {};
            $scope.isAddingRisk = false;
        }

    }
]);