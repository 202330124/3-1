let a = parseInt(prompt("첫번째 숫자를 입력하세요: "));
let b = parseInt(prompt("두번째 숫자를 입력하세요: "));
let c = parseInt(prompt("세번째 숫자를 입력하세요: "));

if(a > b && a > c) {
    document.write(`가장 큰 수는 ${a}입니다.`);
}

else if(b > a && b > c) {
    document.write(`가장 큰 수는 ${b}입니다.`);
}

else if(c > a && c > b) {
    document.write(`가장 큰 수는 ${c}입니다.`);
}