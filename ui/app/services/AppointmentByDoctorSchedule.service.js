/**
 * Created by japnica on 1/25/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .factory('AppointmentByDoctorSchedule',AppointmentByDoctorSchedule);
    AppointmentByDoctorSchedule.$inject=['$resource'];

    function AppointmentByDoctorSchedule($resource){
        var service=$resource('http://localhost:8080/api/bookedTime/:id',{},{
            'query':{method:'GET', isArray:true},
            'getter':{
                        method:'GET',
                        isArray:true
            },
            'get':{
                method:'GET',
                isArray:true,
                transformResponse: function (data) {
                    data = angular.fromJson(data);

                   // console.log(data);
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
