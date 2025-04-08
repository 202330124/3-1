const btn = document.forms[0].elements[7];
const order = document.order;

order.onsubmit = () => {
    const name = document.forms[0].elements[4].value;
    const product = document.forms[0].elements[1].value;
    const quantity = document.forms[0].elements[2].value;

    alert(`${name}님께서 ${product} ${quantity}개를 주문하였습니다.`);  
}