const currentYear = 2025;

let birthYear;
let age;

birthYear = parseInt(prompt("태어난 연도를 입력하세요. (YYYY)", ""));
age = currentYear - birthYear + 1;

if(age < 20) {
    alert("성인이 아닙니다.");
}

alert(`${currentYear}년 현재, ${age}세입니다.`);