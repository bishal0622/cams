/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('app')
    .config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/doctor');

        // Application routes
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'views/login.html'
            })
    }
]);