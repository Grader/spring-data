var jsonValue = $('#valueHolderId').html();
var jsonData = JSON.parse(jsonValue);

$(document).ready(function() {

    $('.submit1').click(function() {
        $(function() {

                let key = $('.search1').val();
                let numberOfFound = 0;
                if (key === "") {
                    alert('Задайте параметр поиска');
                    return false;
                }

                for (let i = 0; i < jsonData.goods.length; i++) {
                    if (jsonData.goods[i].name.toLowerCase().includes(String(key).toLowerCase())) {
                        numberOfFound++;
                        $('.found_goods').append('<br>' + '<div class="products" id="' + jsonData.goods[i].id + '">' +
                            '<div class="img"><img src="/resources/' + jsonData.goods[i].img + '"></img><p font-size="24">' + jsonData.goods[i].name + '<br>' +
                            '</p></div><div class="text_product">$ ' +
                            jsonData.goods[i].price + '</div><div><button class="button" id="' + jsonData.goods[i].id +
                            '">В корзину</button></div></div>');
                    }
                }
                if (numberOfFound === 0) {
                    alert('Ничего не найдено');
                }

        });
        $('.found_goods').empty();
        return false;
    });
});