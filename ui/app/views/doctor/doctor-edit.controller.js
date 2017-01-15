/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('DoctorEditController',DoctorEditController);

    DoctorEditController.$inject=['$stateParams','$uibModalInstance','entity','Doctor','Specialist'];

    function DoctorEditController($stateParams, $uibModalInstance, entity, Doctor,Specialist){
        var vm=this;
        vm.specialists=Specialist.query();
        vm.updateDoctor=updateDoctor;
        vm.doctor=entity;

        function updateDoctor(id){
            vm.isSaving=true;
            Doctor.update({id:id}, vm.doctor, OnSaveSuccess, OnSaveError);
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
