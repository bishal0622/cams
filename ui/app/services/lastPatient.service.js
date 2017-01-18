/**
 * Created by BiSAl MhRzn on 1/17/2017.
 */
/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .factory('LastPatient',LastPatient);

    LastPatient.$inject=['$resource'];

    function LastPatient($resource){
        console.log('LastPatient service');
        var service=$resource('http://localhost:8080/api/patient/lastEntry',{},{
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
