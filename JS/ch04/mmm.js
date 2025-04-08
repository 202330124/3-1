function mmm() {
    let max, mid, min = 0;

    if(a > b && a > c) {
        if(b > c) {
            max = a;
            mid = b;
            min = c;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }

        else {
            max = a;
            mid = c;
            min = b;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }
    }

    if(b > a && b > c) {
        if(a > c) {
            max = b;
            mid = a;
            min = c;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }

        else {
            max = b;
            mid = c;
            min = a;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }
    }

    if(c > a && c > b) {
        if(a > b) {
            max = c;
            mid = a;
            min = b;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }

        else {
            max = c;
            mid = b;
            min = a;

            document.write(`입력받은 세 정수 중 가장 큰 값은 ${max}, 중간 값은 ${mid}, 가장 작은 값은 ${min}입니다.`);
        }
    }
}

let a = parseInt(prompt("첫번째 정수를 입력하세요: "));
let b = parseInt(prompt("두번째 정수를 입력하세요: "));
let c = parseInt(prompt("세번째 정수를 입력하세요: "));

mmm();