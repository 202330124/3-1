const title = document.querySelector("#title");
const portrait = document.querySelector("#profile img");

title.onclick = function() {
    title.innerText = "프로필";
}

portrait.onclick = function() {
    portrait.src = "images/pf2.png";
}