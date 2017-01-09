/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('DoctorScheduleEditController',DoctorScheduleEditController);

    DoctorScheduleEditController.$inject=['$stateParams','$uibModalInstance','entity','DoctorSchedule'];

    function DoctorScheduleEditController($stateParams, $uibModalInstance, entity, DoctorSchedule){
        var vm=this;
        vm.updateDoctorSchedule=updateDoctorSchedule;
        vm.schedule=entity;

        function updateDoctorSchedule(){
            vm.isSaving=true;
            console.log(vm.schedule);
            DoctorSchedule.update(vm.schedule, OnSaveSuccess, OnSaveError);
        }

        function OnSaveSuccess(result){
            vm.isSaving=false;
            $uibModalInstance.close(result);
        }
        function OnSaveError(){
            vm.isSaving=false;
        }
    }
})();
