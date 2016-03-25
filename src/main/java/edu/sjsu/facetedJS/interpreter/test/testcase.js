system.log("/************ TEST CASE 1 ***************/");
// I/O TESTCASE
var k1 = new Label();
var k2 = new Label();
var bankChannel = new Channel("bank.com");
creditCard = setSecurity(k1, "1234-2345-4567-0987", "0000-0000-0000-0000");
goodStanding = setSecurity(k2, true, false);
bankChannel.addPermission(k1);
bankChannel.addPermission(k2);
k1 = null;
k2 = null;
bankChannel.write("Your credit card ("+creditCard+") payment was successful");
bankChannel.write("Good standing : " + goodStanding);
// injection
system.log("---- injection----"); 
var evilChannel = new Channel("evil.com");
evilChannel.write("creditCard="+creditCard);
evilChannel.write("goodStanding="+goodStanding);


system.log("");
system.log("");
system.log("/************ TEST CASE 2 ***************/");
// IF TEST CASE
x = setSecurity(new Label(), true, false);
y = setSecurity(new Label(), true, false);
z = setSecurity(new Label(), true, false);
if (x) {
	if (y) {
		if (z) { out = 1; } else { out = 2; }
	} else {
		if (z) { out = 3; } else { out = 4; }
	}
} else {
	if (y) {
		if (z) { out = 5; } else { out = 6; }
	} else {
		if (z) { out = 7; } else { out = 8; }
	}
}
system.log(" out = ");
system.log(out);
if (x && y) {
	out = -1;
}
system.log(" out = ");
system.log(out);
if (x || y) {
	out = -2;
}
system.log(" out = ");
system.log(out);


system.log("");
system.log("");
system.log("/************ TEST CASE 3 ***************/");
// PRE/POST INCREMENT/DECREMENT TEST CASE
i = setSecurity(new Label(), 0, 10);
system.log(i);
system.log(++i);
system.log(i);
system.log(i++);
system.log(i);
system.log(--i);
system.log(i);
system.log(i--);
system.log(i);
system.log(i++ + i--);
system.log(i);
system.log(--i + ++i);
system.log(i);


system.log("");
system.log("");
system.log("/************ TEST CASE 4 ***************/");
// BINARY OPERATIONS TEST
x = setSecurity(new Label(), 2, 3);
y = setSecurity(new Label(), 4, 5);
z = setSecurity(new Label(), 6, 7);
system.log(x * y + z);
system.log(x - y * z);
system.log(x * y / z);


system.log("");
system.log("");
system.log("/************ TEST CASE 5 ***************/");
// WHILE TEST CASE
sum = 0;
i = setSecurity(new Label(), 10, 3);
while (i > 0 ){
	sum += i;
	i--;
}
system.log("sum = ");
system.log(sum);


system.log("");
system.log("");
system.log("/************ TEST CASE 6 ***************/");
// DO WHILE TEST CASE
sum = 0;
i = 0;
j = setSecurity(new Label(), 10, 3);
while (i++ < j ){
	sum += i;
}
system.log("sum = ");
system.log(sum);


system.log("");
system.log("");
system.log("/************ TEST CASE 7 ***************/");
// FOR LOOP TEST CASE
sum = 0;
k2 = new Label();
for (i = setSecurity(new Label(), 1, 6); i <= 10; i++){
	for (j = setSecurity(k2, 1, 6); j <= 10; j++){
		sum ++;
	}
}
k2 = null;
system.log("sum = ");
system.log(sum);


system.log("");
system.log("");
system.log("/************ TEST CASE 8 ***************/");
// FUNCTION DECL / RETURN TEST CASE
test1 = setSecurity(new Label(), true, false);
if (test1) {
	func1 = function(s) {
		test2 = setSecurity(new Label(), true, false);
		sum = s;
		if (test2){
			for (i = setSecurity(new Label(), 0, 3); i < 5; i++){
				sum = sum + i;
			}
		}
		return sum;
	};
}
system.log("return = ");
system.log(func1(1));


system.log("");
system.log("");
system.log("/************ TEST CASE 9 ***************/");
// ARRAY TEST CASE
var num_list_1 = [1,2,3,4,5];
var num_list_2 = [2,2,2,2,2];
for (i = 0; i < num_list_2.length; i++){
	num_list_2[i] += num_list_1[i]; 
}
system.log("sum of the list : " + num_list_2); // list of sum
var matrix = [[1,2,3,4],
			  [2,3,4,5,6,7],
			  [3,4,5,6]];
output = "2D array to list :";
for (i = 0; i < matrix.length; i++){
	for (j = 0; j < matrix[i].length; j++){
		output += " " + matrix[i][j];
	}
}
system.log(output);


system.log("");
system.log("");
system.log("/************ TEST CASE 10 ***************/");
// OBJECT TEST CASE
school = {
	name:"San Jose State University",
	tel:4081231234,
	students:[{name:"Alice", age:20},
			  {name:"Bob", age:22},
			  {name:"Charle", age:19},
			  {name:"David", age:30}]
};
system.log(school);
system.log("School    : " + school.name);
system.log("Number    : " + school.tel);
school.address = "1 Washington Sq, San Jose, CA 95192";
system.log("Address   : " + school.address);
system.log("Student   : ");
for (i = 0; i < school.students.length; i++){
	system.log(" - " + school.students[i].name + " (age: " + school.students[i].age + ")");
}


system.log("");
system.log("");
system.log("/************ TEST CASE 11 ***************/");
// REFERENCE TEST CASE
c = [1, -2, -3, 11, -7, 101];
k1 = new Label();
k2 = new Label();
publicChannel = new Channel();
privateChannel = new Channel();
x = setSecurity(k1, true, false);
y = setSecurity(k2, true, false);
privateChannel.addPermission(k1);
privateChannel.addPermission(k2);
k1 = null;
k2 = null;
publicChannel.write(c);
privateChannel.write(c);
if (x){
	if (y){
		c = [2,1,0,-1,-2];
	}
}
function zeroOutNegative (array){
	for (i = 0; i < array.length; i++){
		if (array[i] < 0){
			array[i] = 0;
		}
	}
}
publicChannel.write(c);
privateChannel.write(c);
zeroOutNegative(c);
publicChannel.write(c);
privateChannel.write(c);


system.log("");
system.log("");
system.log("/************ TEST CASE 12 ***************/");
// REFERENCE UPDATE TEST CASE
k1 = new Label();
k2 = new Label();
publicChannel = new Channel("public");
privateChannel = new Channel("ford.com");
x = setSecurity(k1, true, false);
y = setSecurity(k2, true, false);
privateChannel.addPermission(k1);
privateChannel.addPermission(k2);
k1 = null;
k2 = null;
function Car(brand, model, hp){
	this.brand = brand;
	this.model = model;
	this.hp = hp;
}
car = new Car("Honda", "accord", 170);
publicChannel.write(car);
privateChannel.write(car);
if (x){
	if (y){
		car["brand"] = "Ford";
		car.model = "Focus";
		car.hp = 200;
	}
}
system.log("");
publicChannel.write(car);
privateChannel.write(car);

system.log("");
system.log("");
system.log("/************ TEST CASE 13 ***************/");
// DECLASSIFICATION TEST CASE
publicChannel = new Channel("public");
privateChannel = new Channel("login-system.com");
function pwTester(){
	var k = new Label();
	
	privateChannel.addPermission(k);

	this.makePassword = function(p){
		return setSecurity(k, p);
	};

	this.hash = function(p){
		var h = md5(p);
		return defacet(k, h);
	};
}
var pwt = new pwTester();
var pwd = pwt.makePassword("secret");
system.log("password = ");
system.log(pwd);

publicChannel.write(pwd);
privateChannel.write(pwd);
pwd = pwt.hash(pwd);
publicChannel.write(pwd);
privateChannel.write(pwd);

