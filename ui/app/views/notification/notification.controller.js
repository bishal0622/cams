/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('NotificationController', NotificationController);

    NotificationController.$inject=['Notification'];

    function NotificationController(Notification) {
        console.log('notification');
        var vm = this;
        vm.loadAll = loadAll;
        vm.notifications = {};
        vm.loadAll();
        vm.success=false;
        vm.error=false;

        function loadAll() {
            Notification.query({}, onSuccess, onError);

            function onSuccess(data) {
                vm.notifications = data;
                vm.success=true;
            }

            function onError() {
                console.log("error");
                vm.error=true;
            }
        }
    }
})();