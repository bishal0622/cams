/**
 * Created by japnica on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('SpecialistDisplayController',SpecialistDisplayController);

    SpecialistDisplayController.$inject=['Specialist'];

    function SpecialistDisplayController(Specialist){
        console.log('display controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.specialists=[];
        vm.loadAll();

        function loadAll(){
            Specialist.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.specialists=data;
        }
        function onError(error){

        }
    }
})();