"use strict";
console.log(' TypeScript Code Started');
var a = 100;
a = null; //as we make strictNullCheck=false
//a='string'; can't reasigned type number into string
var b; //implicitly it will take ANY datatype
b = 'ankita';
console.log(b);
var marks = [1, 4, 6];
console.log(marks);
var student;
student = {
    name: 'abc',
    age: 23,
    pass: true
};
console.log(student);
var Sample = /** @class */ (function () {
    function Sample() {
        this.a = 100;
        this.b = 'abc';
    }
    return Sample;
}());
var sample1 = new Sample();
console.log(sample1.a);
console.log(sample1.b);
console.log('TypeScript Code ended');
