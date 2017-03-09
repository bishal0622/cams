/**
 * Created by BiSAl MhRzn on 1/16/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .factory('Appointment',Appointment);
    Appointment.$inject=['$resource'];

    function Appointment($resource){
        var service=$resource('http://localhost:8080/api/appointment/:id',{},{
            'query':{method:'GET', isArray:true},
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