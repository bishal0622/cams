/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('PatientController', PatientController);

    PatientController.$inject=['Patient','$stateParams','Appointment','LastPatient'];

    function PatientController(Patient,$stateParams,Appointment,LastPatient){
        var vm=this;
        vm.insert=insert;
        vm.patient={};
        console.log('inside  patient ko controller');
        console.log($stateParams.shareData);
        var shareData=$stateParams.shareData;
        vm.patientData={};
        vm.appointment={};

        // console.log("timechecked"+shareData.timeChecked);
        vm.appointment.appointmentDate=shareData.timeChecked;
        vm.appointment.doctorScheduleId=shareData.doctor.id;
        vm.appointment.status="booked";

        console.log("***************");
        console.log(vm.appointment);

        function insert(){
            console.log("patient controller");
            console.log(vm.patient);
            Patient.save(vm.patient, onSuccess, onError);
            function onSuccess(){
                console.log('success');
                // vm.patientData=LastPatient.query();
                // console.log(vm.patientData);
                // var a=vm.patientData;
                // console.log(a);
                // // vm.appointment.patientId=vm.patientData.l.id;
                // // console.log(vm.appointment);

                Appointment.save(vm.appointment,onSuccess, onError);
                function onSuccess(){
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