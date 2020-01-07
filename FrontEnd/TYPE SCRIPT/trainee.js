"use strict";
var StudentDetails = /** @class */ (function () {
    function StudentDetails(name, age, USN, marks, adharno, panno) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.adharno = adharno;
        this.panno = panno;
    }
    return StudentDetails;
}());
var Training = /** @class */ (function () {
    function Training() {
        this.name = 'soumya';
        this.age = 24;
    }
    Training.prototype.data = function () {
        console.log('elloooii');
    };
    Training.prototype.printData = function () {
        console.log('hhiii');
    };
    return Training;
}());
var trainee1 = {
    name: 'simu',
    age: 34,
    printData: function () {
        console.log(this.name, this.age);
    },
    USN: 'ABv12',
    marks: 43,
    adharno: 12345,
    panno: 'DS12',
    data: function () {
        console.log('data function');
    }
};
