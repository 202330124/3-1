function prime() {
    let cnt;
    const prime = [];

    for(let i = 2; i <= a; i++) {
        cnt = 0;
        for(let j = 2; j <= i; j++) {
            if(i % j == 0)
                cnt++;
        }

        if(cnt == 1) {
            prime.push(i);
            // document.write(`${i}`);
        }
    }

    document.write(`${a}이하 숫자 중 소수는 <br>`);
    for(i = 0; i < prime.length; i++) {
        document.write(`${prime[i]}, `);
    }

    document.write(`총 ${prime.length}개입니다.`);
}

let a = parseInt(prompt("정수를 입력해주세요: "));

prime();