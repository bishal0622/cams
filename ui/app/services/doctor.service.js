/**
 * Created by japnica on 1/2/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .factory('Doctor',Doctor);
    Doctor.$inject=['$resource'];

    function Doctor($resource){
        var service=$resource('http://localhost:8080/api/doctor/:id',{},{
            'query':{method:'GET', isArray:true},
            'get':{
                method:'GET',
                transformResponse:function(data){
                    data=angular.fromJson(data);
                    return data;
                }
            },
            'save':{method:'POST',
                transformRequest : angular.identity,
                headers : {
                    'Content-Type' : undefined
                }},
            'update':{method:'PUT'},
            'delete':{method:'DELETE'}
        });
        return service;
    }
})();