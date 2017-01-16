/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .controller('TimeslotController',TimeslotController);

    TimeslotController.$inject=['$stateParams','entity','Doctor','$filter','$state','$uibModalInstance'];

    function TimeslotController($stateParams, entity, Doctor, $filter,$state,$uibModalInstance) {
        var vm = this;
        console.log("timeslot enter");
        vm.doctors = entity;
        vm.show=show;
        vm.clicked=false;
        vm.timeArray=[];
        vm.formPatient=formPatient;
        vm.share={};



        console.log(vm.doctors);

        vm.date= new Date();
        vm.currentDate=vm.date.getDay();
        console.log(vm.currentDate);

        function formPatient(b) {
            console.log("the value of b is")
            console.log(b);
            $uibModalInstance.close();
            // $state.go("patient({shareData:b})");
        }

        function show(a) {
            vm.clicked=true;
            vm.start=a.doctorScheduleFrom;
            vm.stop=a.doctorScheduleTo;

            console.log(vm.start);
            console.log(vm.stop);

            vm.c= new Date(vm.start);
            vm.d= new Date(vm.stop);

            vm.c = $filter('date')(vm.c, "HH:mm");
            var c=vm.c;
            var start=c.split(':');

            vm.d=$filter('date')(vm.d,"HH:mm");
            var stop=vm.d.split(':');

            var newstartdate= new Date();
            var newstopdate=new Date();

            newstartdate.setHours(start[0],start[1]);

            newstopdate.setHours(stop[0],stop[1]);

            // to get exact stop time
            newstopdate.setMinutes(newstopdate.getMinutes()+10)

            do{
                vm.timeArray.push(newstartdate.setMinutes(newstartdate.getMinutes()+10));

                console.log(newstartdate);


             }while (newstartdate.getHours()!=newstopdate.getHours());

            console.log(vm.timeArray);
            vm.share.doctor=a;
        }



 }
})();
