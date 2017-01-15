/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('PatientDeleteController', PatientDeleteController);
    PatientDeleteController.$inject=['Patient','$uibModalInstance','entity'];

    function PatientDeleteController(Patient, $uibModalInstance, entity){
        var vm=this;
        vm.patient=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Patient.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();