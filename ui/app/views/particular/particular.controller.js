/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('ParticularController', ParticularController);

    ParticularController.$inject=['Particular'];

    function ParticularController(Particular){
        var vm=this;
        vm.insert=insert;
        vm.particular={};
        console.log('inside controller');

        function insert(){
            console.log("particular controller");
            console.log(vm.particular);
            Particular.save(vm.particular);
        }
    }
})();