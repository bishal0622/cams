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
        vm.success=false;
        vm.error=false;

        function insert(){
            console.log("specialist controller");
            console.log(vm.specialist);
            Specialist.save(vm.specialist,onSuccess,onError);

            function onSuccess(){
                vm.success=true;
            }
            function onError(){
                vm.error=true;
            }
        }
    }
})();