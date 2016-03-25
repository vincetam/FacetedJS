module.exports = function(grunt){

    grunt.loadNpmTasks('grunt-properties-reader');
    grunt.loadNpmTasks('grunt-antlr4');
    grunt.loadNpmTasks('grunt-contrib-watch');

	grunt.initConfig({
        properties: {
            props: 'config.properties'
		},
        watch: {
            files: ['<%= props.grammarFile %>'],
            tasks: ['antlr4'],
            options : { nospawn : true }
        },
        antlr4: {
            your_target: {
                grammar: '<%= props.grammarFile %>',
                options: {
                    flags: [
                      'visitor', 'listener'
                    ]
                },
			},
		}
	});

    grunt.registerTask('default', ['properties', 'watch']);
    grunt.registerTask('interp', 'Generate Interpreter', function(){
        grunt.task.run('properties','antlr4');
    });
};
