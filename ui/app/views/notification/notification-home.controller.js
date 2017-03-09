/**
 * Created by BiSAl MhRzn on 1/27/2017.
 */
/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('NotificationHomeController', NotificationHomeController);

    NotificationHomeController.$inject=['NotificationPending'];

    function NotificationHomeController(NotificationPending) {
        console.log('notification');
        var vm = this;
        vm.loadAll = loadAll;
        // vm.notificationPending = {};
        vm.loadAll();

        function loadAll() {
            NotificationPending.query().then(function(response){
                vm.notificationPending = response.data;
            });

        }
    }
})();