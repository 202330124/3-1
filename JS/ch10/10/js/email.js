const email = document.querySelector("#userEmail");
const button = document.querySelector("button");
const result = document.querySelector("#result");

button.addEventListener("click", function() {
    let username, domain;

    if(email.value !== "") {
        username = email.value.split("@")[0]; // @ 기준으로 쪼개는 앞부분 저장
        username = username.substring(0, 3);

        domain = email.value.split("@")[1]; // @ 기준으로 쪼개는 뒷부분 저장
        
        result.innerText = `${username}...@${domain}`;
        email.value = "";
    }
});

