var i = 10;

var f = function(){
	var inner = 2;
	return inner + i;
};

var i = 2;
system.log(f());