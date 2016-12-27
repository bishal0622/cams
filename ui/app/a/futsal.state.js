(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('specialist', {
                parent: 'components',
                url: '/specialist',
                data: {
                    authorities: [],
                    pageTitle: 'Registration'
                },
                views: {
                    'content@': {
                        templateUrl: 'components/home.html',
                        controller: 'TodoController',
                        controllerAs: 'vm'
                    }
                }
            });

    }
})();
