(function(angular) {
    'use strict';
    angular
        .module('app', ['ui.router','ngResource'])
        .config(function($stateProvider, $urlRouterProvider) {

            // $urlRouterProvider.otherwise('/home');

            $stateProvider

            // HOME STATES AND NESTED VIEWS ========================================
                .state('a', {
                    url: '/a',
                    templateUrl: 'a/home.html',
                    controller: 'TodoController',
                    controllerAs: 'vm'
                })

                .state('b', {
                    url: '/b',
                    data: {
                        authorities: [],
                        pageTitle: 'Registration'
                    },
                    views: {
                        'content@': {
                            templateUrl: 'b.html',

                        }
                    }
                })


        });

})(angular);
