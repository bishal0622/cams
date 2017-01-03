/**
 * Created by japnica on 1/2/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('Specialist',Specialist);

    Specialist.$inject=['$resource'];

    function Specialist($resource){
        console.log('Specialist service');
        var service=$resource('http://localhost:8080/api/specialist/:id',{},{
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