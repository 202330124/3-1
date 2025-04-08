const btn = document.querySelector("#send");
const send = document.send;

/*
const selectMenu = document.querySelector("#major");

selectMenu.onchange = () => {
    let selectedText = selectMenu.options[selectMenu.selectedIndex].innerText;
    alert(`[${selectedText}]를 선택했습니다.`);
}
*/

send.onsubmit = () => {
    const name = document.forms[0].elements[1];
    const major = document.querySelector("#major");
    const selectedText = major.options[major.selectedIndex].innerText;

    alert(`${selectedText} ${name}학생`);
}