(function immediately(a, b) {
    let square = 0;
    
    for(let i = 1; i < b; i++) {
        square += a * a;
    }

    // let square = a ** b;

    document.write(`${a}의 ${b}제곱은 ${square}입니다.`);
})(parseInt(prompt("첫번째 정수를 입력하세요: ")), parseInt(prompt("두번째 정수를 입력하세요: ")));