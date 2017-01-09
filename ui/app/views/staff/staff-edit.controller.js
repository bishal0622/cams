/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('StaffEditController',StaffEditController);

    StaffEditController.$inject=['$stateParams','$uibModalInstance','entity','Staff'];

    function StaffEditController($stateParams, $uibModalInstance, entity, Staff){
        var vm=this;
        vm.updateStaff=updateStaff;
        vm.staff=entity ;

        function updateStaff(){
            vm.isSaving=true;
            Staff.update(vm.staff, OnSaveSuccess, OnSaveError);
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