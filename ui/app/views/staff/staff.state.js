/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject=['$stateProvider'];

    function stateConfig($stateProvider){
        $stateProvider
            .state('staff',{
                url:'/staff',
                templateUrl:'views/staff/staff.html',
                controller: 'StaffController',
                controllerAs:'vm'
            })
            .state('displayStaff',{
                url:'/displayStaff',
                templateUrl:'views/staff/display-staff.html',
                controller:'StaffDisplayController',
                controllerAs:'vm'
            })
            .state('displayStaff.edit',{
                url:'/{id}/edit',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/staff/staff-edit.html',
                        controller:'StaffEditController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Staff', function(Staff){
                                return Staff.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayStaff', null, {reload: true});
                    });

                }]
            })
            .state('displayStaff.delete',{
                url:'/{id}/delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/staff/staff-delete.html',
                        controller:'StaffDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Staff', function(Staff){
                                return Staff.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('displayStaff', null, {reload:true});
                    });
                }]
            });

    }
})();