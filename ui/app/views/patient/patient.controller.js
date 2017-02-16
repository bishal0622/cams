/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('PatientController', PatientController);

    PatientController.$inject=['Patient','$stateParams','Appointment','Notification'];

    function PatientController(Patient,$stateParams,Appointment,Notification){
        var vm=this;
        vm.insert=insert;
        vm.success=false;
        vm.error=false;
        vm.patient={};
        console.log('inside  patient ko controller');
        console.log($stateParams.shareData);
        var shareData=$stateParams.shareData;
        vm.patientData={};
        vm.appointment={};
        vm.notification={};

        // console.log("timechecked"+shareData.timeChecked);
        vm.appointment.appointmentDate=shareData.timeChecked;
        vm.appointment.doctorScheduleId=shareData.doctor.id;
        vm.appointment.status="pending";

        console.log(vm.appointment);

        function insertNotification() {
            vm.notification.notificationDatetime= new Date().toLocaleString();
            vm.notification.status="unchecked";

            Notification.save(vm.notification, onSuccess, onError);
            function onSuccess(){
                console.log('success');
                vm.success=true;
                console.log(vm.success);
            }
            function onError(){
                console.log('error');
                vm.error=true;
            }
        }

        function insert(){
            console.log("patient controller");
            console.log(vm.patient);
            Patient.save(vm.patient, onSuccess, onError);
            function onSuccess(){
                console.log('success');

                Appointment.save(vm.appointment,onSuccess, onError);
                function onSuccess(){
                    console.log(vm.success);
                    insertNotification();
                    console.log("appointment registered");



                }
                function onError(){
                    console.log("appointment failed");
                }
            }

            function onError(){
                console.log('error');
            }

        }
    }
})();