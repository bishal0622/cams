(function () {
    'use strict';

    angular
        .module('app')
        .factory('Event', Event);

    Event.$inject = ['$resource'];

    function Event ($resource) {
        var service = $resource('api/specialist/:id', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' },
            'update': { method:'PUT' },
            'delete':{ method:'DELETE'}
        });

        return service;
    }
})();
