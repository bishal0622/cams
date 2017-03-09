/**
 * Created by BiSAl MhRzn on 1/27/2017.
 */
/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('NotificationPending',NotificationPending);

    NotificationPending.$inject=['$resource'];

    function NotificationPending($resource){
        console.log('NotificationPending service');
        var service=$resource('http://localhost:8080/api/notification/pending/:id',{},{
            'query':{method:'GET'},
            'get':{
                method:'GET',
                transformResponse:function(data){
                    data=angular.fromJson(data);
                    return data;
                }


            },
            'save':{method:'POST'},
            'update':{method:'PUT'},
            'delete':{method:'DELETE'}
        });
        return service;
    }
})();
