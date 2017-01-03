/**
 * Created by japnica on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('SpecialistDeleteController', SpecialistDeleteController);
    SpecialistDeleteController.$inject=['Specialist','$uibModalInstance','entity'];

    function SpecialistDeleteController(Specialist, $uibModalInstance, entity){
        var vm=this;
        vm.user=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Specialist.delete({id:id},
                function(){
                $uibModalInstance.close(true);
                });
        }
    }
})();