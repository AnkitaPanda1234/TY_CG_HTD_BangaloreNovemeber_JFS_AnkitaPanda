
class StudentDetails
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

interface Trainee extends StudentDetails{
    name: string,
    age: number,
    printData(): void
}

class Training implements Trainee
{
    name= 'soumya';
    age = 24;
    USN:'gash';
     marks: 132;
     adharno: 234;
     panno: 'f4';
     data()
     {
      console.log('elloooii')
     }

    printData()
    {
     console.log('hhiii')
    }
}

let trainee1: Trainee ={
    name: 'simu',
    age: 34,
    printData: function()
    {
        console.log(this.name, this.age);
    },
    USN: 'ABv12',
    marks: 43,
    adharno: 12345,
    panno: 'DS12',

    data:function()
    {
        console.log('data function');
    }

}