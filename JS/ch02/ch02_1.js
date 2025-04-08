let f = parseFloat(prompt("변환할 화씨 온도: "));
let c;

c = ((f - 32) / 1.8).toFixed(1);
alert(`화씨 ${f}도는 섭씨 ${c}도 입니다.`);