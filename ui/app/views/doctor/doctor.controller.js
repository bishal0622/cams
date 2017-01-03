/**
 * Created by japnica on 1/2/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorController', DoctorController);

    DoctorController.$inject=['Specialist','Doctor'];

    function DoctorController(Specialist,Doctor){
        var vm=this;
        vm.specialists=Specialist.query();
        console.log(vm.specialists);
        vm.insert=insert;
        vm.doctor={};
        console.log(vm.doctor);

        function insert(){
            console.log(vm.doctor);
            Doctor.save(vm.doctor,OnSuccess,OnError);
            function OnSuccess(){
                console.log("success");
            }

            function OnError(){
                console.log("Error");
            }
        }
    }
})();