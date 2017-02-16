/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */
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
            .state('notification',{
                url:'/notification',
                templateUrl:'views/notification/notification.html',
                controller: 'NotificationController',
                controllerAs:'vm'
            })
            .state('notificationHome',{
                url:'/notificationHome',
                templateUrl:'views/notification/notification-home.html',
                controller: 'NotificationHomeController',
                controllerAs:'vm'
            })
            .state('notification.accept',{
                url:'/{id}/accept',
                onEnter:['$stateParams','$state','$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/notification/notification-accept.html',
                        controller:'AcceptController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Notification', function(Notification){
                                return Notification.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('notification', null, {reload: true});
                    });

                }]
            })
            .state('notification.delete',{
                url:'/{id}/notification.delete',
                onEnter:['$stateParams','$state', '$uibModal', function($stateParams, $state, $uibModal){
                    $uibModal.open({
                        templateUrl:'views/notification/notification-delete.html',
                        controller:'NotificationDeleteController',
                        controllerAs:'vm',
                        resolve:{
                            entity:['Notification', function(Notification){
                                return Notification.get({id:$stateParams.id});
                            }]
                        }
                    }).result.then(function(){
                        $state.go('notification', null, {reload:true});
                    });
                }]
            });

    }
})();