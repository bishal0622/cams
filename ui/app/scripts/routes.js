/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('app').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/');

        // Application routes
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'views/login.html'
            })

            .state('entity',{
                abstract: true
            })

            .state('patient',{
                url:'/patient',
                templateUrl: 'views/patient/patient.html'
            })
            .state('appointment',{
                url:'/appointment',
                templateUrl: 'views/appointment/appointment.html'
            })


            .state('doctor',{
                url:'/doctor',
                templateUrl:'views/doctor/doctor.html',
                controller: 'DoctorController',
                controllerAs:'vm'
            })

    }
]);