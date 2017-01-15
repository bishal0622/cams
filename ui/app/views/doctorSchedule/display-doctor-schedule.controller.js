/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorScheduleDisplayController',DoctorScheduleDisplayController);

    DoctorScheduleDisplayController.$inject=['DoctorSchedule'];

    function DoctorScheduleDisplayController(DoctorSchedule){
        console.log('display controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.doctorSchedules=[];
        vm.loadAll();

        function loadAll(){
            DoctorSchedule.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.doctorSchedules=data;
        }
        function onError(error){

        }
    }
})();