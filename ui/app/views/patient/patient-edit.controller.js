/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('PatientEditController',PatientEditController);

    PatientEditController.$inject=['$stateParams','$uibModalInstance','entity','Patient'];

    function PatientEditController($stateParams, $uibModalInstance, entity, Patient){
        var vm=this;
        vm.updatePatient=updatePatient;
        vm.patient=entity;

        function updatePatient(id){
            vm.isSaving=true;
            Patient.update({id:id}, vm.patient, OnSaveSuccess, OnSaveError);
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
