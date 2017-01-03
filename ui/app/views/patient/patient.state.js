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
            $urlRouterProvider.otherwise('/');

            // Application routes
            $stateProvider

                .state('patient',{
                    url:'/patient',
                    templateUrl:'views/doctorSchedule/doctor-Schedule.html',
                    controller: 'DoctorScheduleController',
                    controllerAs:'vm'
                })


        }
    ]);