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
                    templateUrl:'views/patient/patient.html',
                    controller: 'PatientController',
                    controllerAs:'vm'
                })
                .state('displayPatient',{
                    url:'/displayPatient',
                    templateUrl:'views/patient/display-Patient.html',
                    controller:'PatientDisplayController',
                    controllerAs:'vm'
                })
                .state('displayPatient.edit',{
                    url:'/{id}/edit',
                    onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                        $uibModal.open({
                            templateUrl:'views/patient/patient-edit.html',
                            controller:'PatientEditController',
                            controllerAs:'vm',
                            resolve:{
                                entity:['Patient', function(Patient){
                                    return Patient.get({id:$stateParams.id});
                                }]
                            }
                        }).result.then(function(){
                            $state.go('displayPatient', null, {reload: true});
                        });

                    }]
                })
                .state('displayPatient.delete',{
                    url:'/{id}/delete',
                    onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                        $uibModal.open({
                            templateUrl:'views/patient/patient-delete.html',
                            controller:'PatientDeleteController',
                            controllerAs:'vm',
                            resolve:{
                                entity:['Patient', function(Patient){
                                    return Patient.get({id:$stateParams.id});
                                }]
                            }
                        }).result.then(function(){
                            $state.go('displayPatient', null, {reload:true});
                        });
                    }]
                });


        }
    ]);