/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('Notification',Notification);

    Notification.$inject=['$resource'];

    function Notification($resource){
        console.log('Notification service');
        var service=$resource('http://localhost:8080/api/notification/:id',{},{
            'query':{method:'GET',isArray:"true"},
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
