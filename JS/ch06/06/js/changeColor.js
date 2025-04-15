const color = document.querySelector(".color");

color.addEventListener("mouseover", function() {
    color.style.backgroundColor = "yellow";
});

color.addEventListener("mouseout", function() {
    color.style.backgroundColor = "white";
});