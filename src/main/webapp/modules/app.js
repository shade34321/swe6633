'use strict';

angular.module('spt', [
    'ngRoute',
    'spt.home',
    'spt.project',
    'spt.member'
]).config([
    '$locationProvider',
    '$routeProvider',
    function($locationProvider,
             $routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'modules/home/home.html',
            controller: 'HomeController'
        }).when('/create-project', {
            templateUrl: 'modules/project/create-project.html',
            controller: 'CreateProjectController'
        }).when('/create-member', {
            templateUrl: 'modules/member/create-member.html',
            controller: 'CreateMemberController'
        }).otherwise({
            redirectTo: '/'
        });
    }
]);