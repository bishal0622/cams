/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('ParticularDeleteController', ParticularDeleteController);
    ParticularDeleteController.$inject=['Particular','$uibModalInstance','entity'];

    function ParticularDeleteController(Particular, $uibModalInstance, entity){
        var vm=this;
        vm.particular=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Particular.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();