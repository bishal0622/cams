/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('ParticularEditController',ParticularEditController);

    ParticularEditController.$inject=['$stateParams','$uibModalInstance','entity','Particular'];

    function ParticularEditController($stateParams, $uibModalInstance, entity, Particular){
        var vm=this;
        vm.updateParticular=updateParticular;
        vm.particular=entity;

        function updateParticular(){
            vm.isSaving=true;
            Particular.update(vm.particular, OnSaveSuccess, OnSaveError);
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
