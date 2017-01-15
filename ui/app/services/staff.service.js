/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('Staff',Staff);

    Staff.$inject=['$resource'];

    function Staff($resource){
        console.log('Staff service');
        var service=$resource('http://localhost:8080/api/staff/:id',{},{
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