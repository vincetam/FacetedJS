out = 0;
if (s1) {
	if (s2) {
		if (s3) { out1 = 1; } else { out = 2; }
	} else {
		if (s3) { out1 = 3; } else { out = 4; }
	}
} else {
	if (s2) {
		if (s3) { out1 = 5; } else { out = 6; }
	} else {
		if (s3) { out1 = 7; } else { out = 8; }
	}
}
if (s4) {
	if (s5) {
		if (s6) { out2 = 100; } else { out2 = 102; }
	} else {
		if (s6) { out2 = 103; } else { out2 = 104; }
	}
} else {
	if (s5) {
		if (s6) { out2 = 105; } else { out2 = 106; }
	} else {
		if (s6) { out2 = 107; } else { out2 = 108; }
	}
}
if (s7) {
	if (s8) { out3 = 109; } else { out3 = 110; }
} else {
	if (s8) { out3 = 111; } else { out3 = 112; }
}

out = out1 + out2 + out3;
i = out;
i = ++i;
i++;
--i;
i--;
i = i++ + i--;
i = --i + ++i;

var z = 0;
for (j = 0; j < i; j++){
	z += j;
}
