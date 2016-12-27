(function(angular) {
    'use strict';
    angular
        .module('app')
        .controller('TodoController', TodoController);

    TodoController.$inject = ['Event'];

    function TodoController(Event) {
        var vm=this;

        vm.special={};
        vm.show=show;
        console.log("controller");



        function show() {
            console.log("show");
            vm.special=Event.query();
            console.log(vm.special);
        }




    }

})(angular);
