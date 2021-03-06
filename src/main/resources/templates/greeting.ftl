<#import "parts/common.ftl" as c>

<@c.page>

<div class="shadow1"></div>
    <div class="field">
    </div>


    <div class="header_category">
                  <p class="text_category">Автомобили</p>
              </div>
              <div class="category" id="auto">
              <#list goods as good>

              <#if good.cat == "auto">
              <br>
              <div class="products" id="${good.id}">
              <div class="img"><img src="/static/imgs/${good.img}"></img>
              <p>${good.tag}
              <br></p></div><div class="text_product">USD ${good.price}</div>
              <form method="get" action="/cart">

                      <div><button class="btn btn-primary" name="basket" value="${good.id}" <input type="submit" id="${good.id}">В корзину</button>
                      </div>
                      </form>
              </div>
              </#if>
                 </#list>
              </div>

                  <div class="header_category">
                      <p class="text_category">Мотоциклы</p>
                  </div>
                  <div class="category" id="moto">
                  <#list goods as good>

                  <#if good.cat == "moto">
                  <br>
                  <div class="products" id="${good.id}">
                  <div class="img"><img src="/static/imgs/${good.img}"></img>
                  <p>${good.tag}
                  <br></p></div><div class="text_product">USD ${good.price}</div>
                  <form method="get">
                          <div><button class="btn btn-primary" name="basket" value="${good.id}" <input type="submit" id="${good.id}">В корзину</button>
                          </div>
                          </form>
                  </div>
                  </#if>
                     </#list>
                  </div>

    <footer class="footer">
                <p id="text_footer">
            Stolbov production
        </p>
    </footer>

    <div id="popup_name" class="popup_block">
        <h2>Поиск</h2>
        <form method="get">
            <p><input type="search" name="quest" placeholder="Название товара.." autofocus class="search1" value=""></p>
            <p><input type="submit" value="Найти" class="submit1"></p>
        </form>
        <div class="found_goods">
        </div>
    </div>
    <div id="popup2" class="popup_block">
        <h2>Корзина</h2>
        <div class="selected_goods">

        </div>
        <div class="text_basket">
            <div class="amount">
                <p>Сумма товаров:</p>
            </div>
            <div class="discount">
                <p>Скидка:</p>
            </div>
            <div class="total">
                <p>Итого:</p>
            </div>
        </div>
        <div class="data_basket">
            <div class="amount_val">
            </div>
            <div class="discount_val">
            </div>
            <div class="total_val">
            </div>
        </div>
    </div>

</@c.page>
