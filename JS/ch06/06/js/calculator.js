function calculator(operator) {
    const fisrtNum = parseInt(document.querySelector("#firstNum").value);
    const secondNum = parseInt(document.querySelector("#secondNum").value);
    let result;

    if(isNaN(fisrtNum) || isNaN(secondNum)) {
        result = "숫자를 입력하세요!";
    }

    else {
        switch(operator) {
            case '+':
            result = fisrtNum + secondNum;

            break;

            case '-':
            result = fisrtNum - secondNum;

            break;

            case '*':
            result = fisrtNum * secondNum;

            break;

            case '/':
            result = fisrtNum / secondNum;

            break;
        }
    }

    document.querySelector("#result").innerText = result;
}