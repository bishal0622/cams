/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('PatientController', PatientController);

    PatientController.$inject=['Patient'];

    function PatientController(Patient){
        var vm=this;
        vm.insert=insert;
        vm.patient={};
        console.log('inside controller');

        function insert(){
            console.log("patient controller");
            console.log(vm.patient);
            Patient.save(vm.patient);
        }
    }
})();