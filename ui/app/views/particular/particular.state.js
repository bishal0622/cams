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
            .state('particular',{
                url:'/particular',
                templateUrl:'views/particular/particular.html',
                controller: 'ParticularController',
                controllerAs:'vm'
            })
            .state('displayParticular',{
                url:'/displayParticular',
                templateUrl:'views/particular/display-particular.html',
                controller:'ParticularDisplayController',
                controllerAs:'vm'
            })
            .state('displayParticular.edit',{
                url:'/{id}/edit',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/particular/particular-edit.html',
                        controller:'ParticularEditController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Particular', function(Particular){
                                return Particular.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayParticular', null, {reload: true});
                    });

                }]
            })
            .state('displayParticular.delete',{
                url:'/{id}/delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/particular/particular-delete.html',
                        controller:'ParticularDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Particular', function(Particular){
                                return Particular.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayParticular', null, {reload:true});
                    });
                }]
            });

    }
})();