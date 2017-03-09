
/**
 * Created by BiSAl MhRzn on 1/27/2017.
 */

(function(){
    'use strict';
    angular
        .module('app')
        .controller('NotificationDeleteController', NotificationDeleteController);
    NotificationDeleteController.$inject=['Notification','$uibModalInstance','entity'];

    function NotificationDeleteController(Notification, $uibModalInstance, entity){
        var vm=this;
        vm.notification=entity;
        vm.clear=clear;
        vm.confirmDelete=confirmDelete;

        function clear(){
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete(id){
            Notification.delete({id:id},
                function(){
                    $uibModalInstance.close(true);
                });
        }
    }
})();