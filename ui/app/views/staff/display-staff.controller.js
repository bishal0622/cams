/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('StaffDisplayController',StaffDisplayController);

    StaffDisplayController.$inject=['Staff'];

    function StaffDisplayController(Staff){
        console.log('staff controller');
        var vm=this;
        vm.loadAll=loadAll;
        vm.staffs=[];
        vm.loadAll();

        function loadAll(){
            Staff.query({},onSuccess, onError);
        }
        function onSuccess(data){
            vm.staffs=data;
        }
        function onError(error){

        }
    }
})();