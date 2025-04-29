const p = document.querySelectorAll("p");
const newP = document.createElement("p");

p.forEach(p => {
    p.addEventListener("click", () => {
        newP.textContent = "태그 추가하기";

        p.parentNode.insertBefore(newP, p);
    });
});