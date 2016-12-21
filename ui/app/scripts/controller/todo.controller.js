(function(angular) {
    'use strict';
    angular
        .module('app')
        .controller('TodoController', TodoController);

    TodoController.$inject = ['$scope'];

    function TodoController($scope) {
        $scope.todos = [
            {'title': 'First Todo', 'done': false}
        ];
        $scope.add = add;
        $scope.clearCompleted = clearCompleted;

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        function add() {
            $scope.todos.unshift({'title': $scope.newTodo, 'done': false});
            $scope.newTodo = "";
        }

        function clearCompleted() {
            $scope.todos = $scope.todos.filter(function(todo) {
                return !todo.done;
            });
        }
    }

})(angular);
