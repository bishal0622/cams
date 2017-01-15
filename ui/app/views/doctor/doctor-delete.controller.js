/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorDeleteController', DoctorDeleteController);
    DoctorDeleteController.$inject=['Doctor','$uibModalInstance','entity'];

    function DoctorDeleteController(Doctor, $uibModalInstance, entity){
        var vm=this;
        vm.doctor=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Doctor.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();