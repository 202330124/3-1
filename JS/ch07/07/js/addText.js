const title = document.querySelector("h2");

order.addEventListener("click", () => {
    let newP = document.createElement("p");
    let textNode = document.createTextNode(title.innerText);

    newP.appendChild(textNode);
    newP.style.fontSize = "0.8em";
    newP.style.color = "blue";
    
    orderInfo.appendChild(newP);
}, {once: true});