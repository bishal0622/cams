(function(){
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject=['$stateProvider'];

    function stateConfig($stateProvider){
        $stateProvider
            .state('doctor',{
                url:'/doctor',
                templateUrl:'views/doctor/doctor.html',
                controller: 'DoctorController',
                controllerAs:'vm'
            })
            .state('displayDoctor',{
                url:'/displayDoctor',
                templateUrl:'views/doctor/display-doctor.html',
                controller:'DoctorDisplayController',
                controllerAs:'vm'
            })
            .state('displayDoctor.edit',{
                url:'/{id}/edit',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/doctor/doctor-edit.html',
                        controller:'DoctorEditController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Doctor', function(Doctor){
                                return Doctor.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayDoctor', null, {reload: true});
                    });

                }]
            })
            .state('displayDoctor.delete',{
                url:'/{id}/delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/doctor/doctor-delete.html',
                        controller:'DoctorDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Doctor', function(Doctor){
                                return Doctor.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayDoctor', null, {reload:true});
                    });
                }]
            });

    }
})();