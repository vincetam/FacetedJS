function Object() {};
function Channel(identifier){
	var domain = identifier;
	var labels = [];

	this.write = function(msg) {
		writeToChannel(labels, "writing to " + domain + " :");
		writeToChannel(labels, msg);
	};
	this.addPermission = function(k){
		labels.push(k);
	};

	this.getId = function() {
		return domain;
	};
}