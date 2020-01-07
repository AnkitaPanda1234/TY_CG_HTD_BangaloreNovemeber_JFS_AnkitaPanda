"use strict";
var Student1 = /** @class */ (function () {
    function Student1(name, age, USN, marks, adharno, panno) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.adharno = adharno;
        this.panno = panno;
    }
    return Student1;
}());
var std = {
    name: "Ankita panda",
    age: 21,
    USN: "e23",
    marks: 65
};
var student2 = new Student1('mama', 23, 'ABCc12', 12, undefined, 'vbhgr4');
var clearedStudents = [
    new Student1('jayashree', 25, 'abc12', 76),
    new Student1('rupashree', 21, 'bgf34', 87),
];
console.log(clearedStudents);
