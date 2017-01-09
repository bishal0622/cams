/**
 * Created by BiSAl MhRzn on 1/4/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('StaffController', StaffController);

    StaffController.$inject=['Staff'];

    function StaffController(Staff){
        var vm=this;
        vm.insert=insert;
        vm.staff={};
        console.log('inside controller');

        function insert(){
            console.log("Staff controller");
            console.log(vm.staff);
            Staff.save(vm.staff);
        }
    }
})();