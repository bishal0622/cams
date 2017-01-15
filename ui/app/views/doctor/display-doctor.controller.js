/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('DoctorDisplayController',DoctorDisplayController);

    DoctorDisplayController.$inject=['Doctor'];

    function DoctorDisplayController(Doctor){
        console.log('doctor controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.doctors=[];
        vm.loadAll();

        function loadAll(){
            Doctor.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.doctors=data;
        }
        function onError(error){

        }
    }
})();