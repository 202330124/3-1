let a = random => {
    let i = Math.floor(Math.random() * 100 + 1);

    if(random > i) {
        document.write("too Big");
    }

    else {
        document.write("too Small");
    }
}

a(parseInt(prompt("정수를 입력하세요: ")));