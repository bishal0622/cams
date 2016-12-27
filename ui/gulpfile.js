var gulp = require('gulp');
var $ = require('gulp-load-plugins')();
var connect=  require('gulp-connect');

gulp.task('start-server', function() {
    $.connect.server({
        root: ['app', '.tmp'],
        livereload: true,
        // Change this to '0.0.0.0' to access the server from outside.
        port: 9000,
        apiPort:8080


    });
});

gulp.task('default', ['start-server']);
