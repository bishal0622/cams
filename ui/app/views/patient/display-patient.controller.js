/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('PatientDisplayController',PatientDisplayController);

    PatientDisplayController.$inject=['Patient'];

    function PatientDisplayController(Patient){
        console.log('display controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.patients=[];
        vm.loadAll();

        function loadAll(){
            Patient.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.patients=data;
        }
        function onError(error){

        }
    }
})();