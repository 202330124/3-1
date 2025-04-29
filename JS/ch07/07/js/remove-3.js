const buttons = document.querySelectorAll("p > span"); // 모든 삭제 버튼을 가져옵니다.

for(let button of buttons) {
    button.addEventListener("click", function() { // 항목을 클릭했을 때 실행할 함수입니다.
        this.parentNode.remove(this); // 부모 노드에서 삭제합니다.
    });
}