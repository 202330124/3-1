let a = parseInt(prompt("정수를 입력해주세요: "));
let i, j, cnt = 0;
const prime = [];

for(i = 2; i <= a; i++) {
    for(j = 2; j < i; j++) {
        if(i % j == 0)
            cnt++;
    }

    if(cnt == 2) {
        prime.push(i);
        // document.write(`${i}`);
        cnt = 0;
    }
}

document.write(`${a}이하 숫자 중 소수는 <br>`);
for(i = 0; i < prime.length; i++) {
    document.write(`${prime[i]}, `);
}
document.write("입니다.");