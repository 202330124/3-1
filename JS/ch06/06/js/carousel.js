const container = document.querySelector("#container"); // 캐러셀 영역
const pics = ['pic-1.jpg', 'pic-2.jpg', 'pic-3.jpg', 'pic-4.jpg', 'pic-5.jpg']; // 이미지 배열

container.style.backgroundImage = `url(images/${pics[0]})`; // 첫번째 이미지를 기본 이미지로 표시

const arrows = document.querySelectorAll(".arrow");
let i = 0;

arrows.forEach(arrow => {
    arrow.addEventListener("click", (e) => {
        if(e.target.id === "left") {
            // 이전 이미지 표시
            i--;
            if(i < 0) {
                i = pics.length - 1;
            }
        }

        else if(e.target.id === "right") {
            // 다음 이미지 표시
            i++;
            if(i >= pics.length) {
                i = 0;
            }
        }

        container.style.backgroundImage = `url(images/${pics[i]})`;
    });
});