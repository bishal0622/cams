/**
 * Created by BiSAl MhRzn on 1/3/2017.
 */
(function(){
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject=['$stateProvider'];

    function stateConfig($stateProvider){
        $stateProvider
            .state('home',{
                url:'/home',
                templateUrl:'views/home/home.html'
            })
    }
})();