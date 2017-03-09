/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function () {
    'use strict';
    angular
        .module('app')
        .controller('DoctorDisplayController', DoctorDisplayController);

    DoctorDisplayController.$inject = ['Doctor','Specialist','Search'];

    function DoctorDisplayController(Doctor,Specialist,Search) {
        console.log('doctor controller');
        var vm = this;
        vm.specialists=Specialist.query();
        vm.loadAll = loadAll;
        vm.doctors = {};

        function loadAll(id) {
            console.log(id);
            vm.doctors= Search.get({id:id}, onSuccess, onError);
            console.log(vm.doctors);
        }

        function onSuccess() {
        }

        function onError() {
        }
    }
})();