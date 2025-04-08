let counter = 0;

let timer = setInterval(() => {
    document.write("안녕하세요?");
    counter++;

    if(counter === 5) {
        clearInterval(timer);
    }
}, 2000);