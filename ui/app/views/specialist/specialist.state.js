/**
 * Created by japnica on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject=['$stateProvider'];

    function stateConfig($stateProvider){
        $stateProvider
            .state('specialist',{
                url:'/specialist',
                templateUrl:'views/specialist/specialist.html',
                controller: 'SpecialistController',
                controllerAs:'vm'
            })
            .state('displaySpecialist',{
                url:'/displaySpecialist',
                templateUrl:'views/specialist/display-specialist.html',
                controller:'SpecialistDisplayController',
                controllerAs:'vm'
            })
            .state('displaySpecialist.edit',{
                url:'/{id}/edit',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/specialist/specialist-edit.html',
                        controller:'SpecialistEditController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Specialist', function(Specialist){
                                return Specialist.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displaySpecialist', null, {reload: true});
                    });

                }]
            })
            .state('displaySpecialist.delete',{
                url:'/{id}/delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/specialist/specialist-delete.html',
                        controller:'SpecialistDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Specialist', function(Specialist){
                                return Specialist.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displaySpecialist', null, {reload:true});
                    });
                }]
            });

    }
})();