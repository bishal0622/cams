/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('ParticularDisplayController',ParticularDisplayController);

    ParticularDisplayController.$inject=['Particular'];

    function ParticularDisplayController(Particular){
        console.log('display controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.particulars=[];
        vm.loadAll();

        function loadAll(){
            Particular.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.particulars=data;
        }
        function onError(error){

        }
    }
})();