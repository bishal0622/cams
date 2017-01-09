/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('TimeslotController',TimeslotController);

    TimeslotController.$inject=['$stateParams','entity','DoctorSchedule'];

    function TimeslotController($stateParams, entity, DoctorSchedule) {
        var vm = this;
        console.log("timeslot enter");
        vm.schedule = entity;
        var checkday = false;

    }
})();
