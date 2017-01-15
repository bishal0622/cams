/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .factory('AuthorityStaff',AuthorityStaff);
    AuthorityStaff.$inject=['$resource'];

    function AuthorityStaff($resource){
        var service=$resource('http://localhost:8080/api/authorityStaff/:id',{},{
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