/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('Particular',Particular);

    Particular.$inject=['$resource'];

    function Particular($resource){
        console.log('Particular service');
        var service=$resource('http://localhost:8080/api/particular/:id',{},{
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
