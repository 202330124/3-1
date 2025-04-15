const button = document.querySelector("button");
let a = true;

button.onclick = function() {
    if(a) {
        document.getElementById("img").src="./images/pic-2.jpg";
    }
    
    else {
        document.getElementById("img").src="./images/pic-1.jpg";
    }

    a = !a;
}