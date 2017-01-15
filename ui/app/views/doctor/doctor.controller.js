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
            vm.file=vm.photo;
            console.log('file is ' );
            console.dir(vm.file);
            console.log(vm.doctor);
            vm.fd = new FormData();
            vm.fd.append('file', vm.file);
            vm.fd.append('doctor',angular.toJson(vm.doctor,true));
            console.log('Scope of user'+vm.doctor);
            console.log(vm.fd);
            Doctor.save(vm.fd,OnSuccess,OnError);
            function OnSuccess(){
                console.log("success");
            }

            function OnError(){
                console.log("Error");
            }
        }
    }
})();