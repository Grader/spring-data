let selectedGoods = [];
let discount = Math.floor(Math.random() * (30 - 1)) + 1;

let count = 0;
$('.count').append(count);

$(document).ready(function() {
    $('.category').on('click', '.button', function() {
        let clickId = $(this).prop('id');
        selectedGoods.push(clickId);
        count++;
        $('.count').empty();
        $('.count').append(count);
    });

    $('.selected_goods').on('click', '.delete', function() {
        let clickId = $(this).prop('id');
        selectedGoods.splice(selectedGoods.indexOf(clickId), 1);
        $('.count').empty();
        count--;
        $('.count').append(count);
    });
});

$('#basket').click(function() {
    generator();
});

$('.selected_goods').on('click', '.delete', function() {
    generator();
});

//$('.discount_val').append('<p>' + discount + '</p>');

console.log(count);

//function generator() {
//    $.getJSON('http://127.0.0.1:5500/data/goods.json', function(data) {
//
//        $('.selected_goods').empty();
//        let amount = 0;
//        let total = 0;
//
//        for (let i = 0; i < data.goods.length; i++) {
//            if (selectedGoods.indexOf(data.goods[i].id) != -1) {
//                $('.selected_goods').append('<br>' + '<div class="products opened" id="' + data.goods[i].id + '">' +
//                    '<div class="img"><img src="' + data.goods[i].img + '"></img><p font-size="24">' + data.goods[i].name + '<br>' +
//                    '</p></div><div class="text_product">$ ' +
//                    data.goods[i].price + '</div><div><button class="delete" id="' + data.goods[i].id +
//                    '">Удалить</button></div></div>');
//                amount = Number(amount);
//                amount = amount + Number(data.goods[i].price);
//            }
//        }
//        total = amount - amount * (discount / 100);
//        $('.amount_val').empty();
//        $('.total_val').empty();
//        $('.amount_val').append('<p>' + amount + '</p>');
//        $('.total_val').append('<p>' + total + '</p>');
//    });
//};