k1 = new Label();
k2 = new Label();
publicChannel = new Channel("public");
privateChannel = new Channel("private");
x = setSecurity(k1, true, false);
y = setSecurity(k2, true, false);
privateChannel.addPermission(k1);
privateChannel.addPermission(k2);
k1 = null;
k2 = null;

// a = [1,2,3];
// if (x){
// 	a = [4,5];
// }

// a[0] = 100;

// system.log(a);

// publicChannel.write(a);
// publicChannel.write("ff" + a);

// b = a + "ff";
// system.log(b);
// publicChannel.write(b);

// < 0x400 ? [< 0x400 ? 100 : 4 >, 5] : [< 0x400 ? 1 : 100 >, 2, 3] >
// writing to public :
// [100, 2, 3]
// writing to public :
// [< 0x400 ? 1 : 100 >, 2, 3]ff
// < 0x400 ? "[< 0x400 ? 100 : 4 >, 5]ff" : "[< 0x400 ? 1 : 100 >, 2, 3]ff" >
// writing to public :
// [< 0x400 ? 1 : 100 >, 2, 3]ff


arr = [1,2,3];
if (x) {
	arr = [3,4,5];
}
a = arr + "fpo";
publicChannel.write(a);