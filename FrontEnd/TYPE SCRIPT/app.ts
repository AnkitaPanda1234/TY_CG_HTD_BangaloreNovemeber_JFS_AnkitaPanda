console.log(' TypeScript Code Started');

let a=100;
 a=null;//as we make strictNullCheck=false


//a='string'; can't reasigned type number into string

let b;  //implicitly it will take ANY datatype

b='ankita';
console.log(b);
let marks=[1,4,6];
console.log(marks);

let student: {name: string,age: number,pass: boolean};
student={

    name:'abc',
    age: 23,
    pass: true
}
console.log(student.name);

class Sample
{
    a = 100;
    b = 'abc';
}
let sample1=new Sample();
console.log(sample1.a);
console.log(sample1.b);
//ACCESS SPECIFIER

class Student{
    constructor(
       public  name: string,
       public age: number,
       public USN: string,
       public marks: number
    ){}
   printDetails(): void  //declaring fumction inside class no need to write keyword function
   {
       console.log(`
       Name is ${this.name},
       age is ${this.age},
       USN is ${this.USN},
       Marks are ${this.marks}

       
       `);
   }


}
let student1=new Student('Ankita',34,'qwerty124',101);
console.log('name is',student1.name); 
student1.printDetails();

console.log('TypeScript Code ended');



