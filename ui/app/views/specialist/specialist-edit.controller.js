/**
 * Created by japnica on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('SpecialistEditController',SpecialistEditController);

    SpecialistEditController.$inject=['$stateParams','$uibModalInstance','entity','Specialist'];

    function SpecialistEditController($stateParams, $uibModalInstance, entity, Specialist){
        var vm=this;
        vm.updateSpecialist=updateSpecialist;
        vm.specialist=entity;

        function updateSpecialist(id){
            vm.isSaving=true;
            Specialist.update({id:id},vm.specialist, OnSaveSuccess, OnSaveError);
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