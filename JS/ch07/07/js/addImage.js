imgBtn.addEventListener("click", () => {
    let imgNode = document.createElement("img");
    let srcNode = document.createAttribute("src");

    srcNode.value = document.getElementById("src").value;
    imgNode.setAttributeNode(srcNode);

    document.body.appendChild(imgNode);
})