/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('PatientController', PatientController);

    PatientController.$inject=['Patient','$stateParams','Appointment'];

    function PatientController(Patient,$stateParams,Appointment){
        var vm=this;
        vm.insert=insert;
        vm.patient={};
        console.log('inside  patient ko controller');
        console.log($stateParams.shareData);
        var shareData=$stateParams.shareData;
        vm.patientData=[];
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
                vm.p=Patient.query();

                vm.patientData=Patient.get({id:vm.p.indexOf($last)});
                console.log(vm.patientData);
                // var a=vm.patientData[0];
                // console.log(a);
                //
                // console.log("last ko data");
                // console.log(vm.patientData.length);

                // vm.appointment.patientId=
                // Appointment.save();
            }

            function onError(){
                console.log('error');
            }
        }
    }
})();