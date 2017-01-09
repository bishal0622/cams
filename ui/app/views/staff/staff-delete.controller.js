/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('StaffDeleteController', StaffDeleteController);
    StaffDeleteController.$inject=['Staff','$uibModalInstance','entity'];

    function StaffDeleteController(Staff, $uibModalInstance, entity){
        var vm=this;
        vm.staff=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Staff.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();