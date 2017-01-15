/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject=['$stateProvider'];

    function stateConfig($stateProvider){
        $stateProvider
            .state('doctorSchedule',{
                url:'/doctorSchedule',
                templateUrl:'views/doctorSchedule/doctor-schedule.html',
                controller: 'DoctorScheduleController',
                controllerAs:'vm'
            })
            .state('displayDoctorSchedule',{
                url:'/displayDoctorSchedule',
                templateUrl:'views/doctorSchedule/display-doctor-schedule.html',
                controller:'DoctorScheduleDisplayController',
                controllerAs:'vm'
            })
            .state('displayDoctorSchedule.edit',{
                url:'/{id}/edit',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/doctorSchedule/doctor-schedule-edit.html',
                        controller:'DoctorScheduleEditController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['DoctorSchedule', function(DoctorSchedule){
                                return DoctorSchedule.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayDoctorSchedule', null, {reload: true});
                    });

                }]
            })
            .state('displayDoctorSchedule.delete',{
                url:'/{id}/delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/doctorSchedule/doctor-schedule-delete.html',
                        controller:'DoctorScheduleDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['DoctorSchedule', function(DoctorSchedule){
                                return DoctorSchedule.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayDoctorSchedule', null, {reload:true});
                    });
                }]
            });

    }
})();