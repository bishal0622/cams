/**
 * Created by japnica on 1/2/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('SpecialistController', SpecialistController);

    SpecialistController.$inject=['Specialist'];

    function SpecialistController(Specialist){
        var vm=this;
        vm.insert=insert;
        vm.specialist={};
        console.log('inside controller');

        function insert(){
            console.log("specialist controller");
            console.log(vm.specialist);
            Specialist.save(vm.specialist);
        }
    }
})();