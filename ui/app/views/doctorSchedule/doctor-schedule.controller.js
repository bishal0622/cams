/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */

(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorScheduleController', DoctorScheduleController);

    DoctorScheduleController.$inject=['DoctorSchedule','Doctor'];

    function DoctorScheduleController(DoctorSchedule,Doctor){
        var vm=this;
        vm.doctors=Doctor.query();
        console.log(vm.doctors);
        vm.insert=insert;
        vm.doctorSchedule={};
        console.log(vm.doctorSchedule);
        vm.success=false;
        vm.error=false;

        function insert(){
            console.log(vm.doctor);
            DoctorSchedule.save(vm.doctorSchedule,OnSuccess,OnError);
            function OnSuccess(){
                console.log("success");
                vm.sucess=true;
            }

            function OnError(){
                console.log("Error");
                vm.error=true;
            }
        }
    }
})();