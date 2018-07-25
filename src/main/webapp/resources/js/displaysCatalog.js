$(function() {
    $.getJSON('http://127.0.0.1:5500/data/goods.json', function(data) {

        for (let i = 0; i < data.goods.length; i++) {
            $('#' + data.goods[i].cat).append('<br>' + '<div class="products" id="' + data.goods[i].id + '">' +
                '<div class="img"><img src="' + data.goods[i].img + '"></img><p>' + data.goods[i].name + '<br>' +
                '</p></div><div class="text_product">$ ' +
                data.goods[i].price + '</div><div><button class="button" id="' + data.goods[i].id +
                '">В корзину</button></div></div>');
        }
    });
});