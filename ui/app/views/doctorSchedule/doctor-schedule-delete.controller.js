/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorScheduleDeleteController', DoctorScheduleDeleteController);
    DoctorScheduleDeleteController.$inject=['DoctorSchedule','$uibModalInstance','entity'];

    function DoctorScheduleDeleteController(DoctorSchedule, $uibModalInstance, entity){
        var vm=this;
        vm.doctorSchedule=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            DoctorSchedule.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();