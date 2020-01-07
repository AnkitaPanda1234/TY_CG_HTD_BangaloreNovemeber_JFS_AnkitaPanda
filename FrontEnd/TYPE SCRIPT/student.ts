class Student1
{
   constructor(
       public name: string,
       public age: number,
       public USN: string,
       public marks: number,
       public adharno ?: number,
       public panno ?: string 
   )
   {

   }
}
let std: Student1 =
{
    name: "Ankita panda",
    age: 21,
    USN: "e23",
    marks: 65
}

let student2=new Student1( 'mama',23,'ABCc12',12,undefined,'vbhgr4');


let clearedStudents=[
    new Student1('jayashree',25,'abc12',76),
    new Student1('rupashree',21,'bgf34',87),
]
console.log(clearedStudents);