(function(){
    'use strict';

    angular
        .module('app')
        .factory('Search',Search);
    Search.$inject=['$resource'];

    function Search($resource){
        var service=$resource('http://localhost:8080/api/search/:id',{},{
            'query':{method:'GET', isArray:true},
            'get':{
                method:'GET',
               isArray:true
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
