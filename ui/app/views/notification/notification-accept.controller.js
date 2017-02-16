/**
 * Created by BiSAl MhRzn on 1/26/2017.
 */

(function(){
    'use strict';

    angular
        .module('app')
        .controller('AcceptController',AcceptController);

    AcceptController.$inject=['$stateParams','$uibModalInstance','entity','Notification'];

    function AcceptController($stateParams, $uibModalInstance, entity, Notification){
        var vm=this;
        vm.accepted=accepted;
        vm.rejected=rejected;
        vm.notification=entity;

        function accepted(id) {
            vm.notification.confirmedDatetime= new Date().toLocaleString();
            vm.notification.status="booked";
            Notification.update({id:id},vm.notification, OnSaveSuccess, OnSaveError);
        }

        function rejected(id) {
            vm.notification.confirmedDatetime= "null";
            vm.notification.status="rejected";
            Notification.update({id:id},vm.notification, OnSaveSuccess, OnSaveError);

        }
        function OnSaveSuccess(result){
            vm.isSaving=false;
            $uibModalInstance.close(result);
        }
        function OnSaveError(){
            vm.isSaving=false;
        }


    }
})();
