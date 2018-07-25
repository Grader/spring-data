<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head>
    <meta charset="utf-8">
    <title>Магазин</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_modal.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>
    <header>
        <div>
            <div id="header_name">${user.login}</div>
            <div id="header_exit">
                <a href="authorization" target="_self">Выйти</a>
            </div>
            <div id="header_exit">
                            <a href="index" target="_self">На главную</a>
                        </div>
            <div id="header_basket">
                <a href="basket" class="poplight" id="basket"><button>Корзина</button><button class="count"></button></a>
            </div>
            <div id="header_search">
                <a href="#?w=1600" rel="popup_name" class="poplight"><button>Поиск</button></a>
            </div>
        </div>
    </header>

    <div class="shadow1"></div>
    <div class="field">
    </div>
    <div class="header_category">
        <p class="text_category">Автомобили</p>
    </div>
    <div class="category" id="auto">
    <c:forEach items="${goods}" var="good">
    <c:if test="${good.getCat() eq 'auto'}">
    <br>
    <div class="products" id="${good.getId()}">
    <div class="img"><img src=${pageContext.request.contextPath}/resources/${good.getImg()}></img>
    <p>${good.getName()}
    <br></p></div><div class="text_product">USD ${good.getPrice()}</div>
    <form:form modelAttribute="user" method="post" action="basket" >
            <div><button class="button" name="basket" value="${good.getId()}" <input type="submit" id="${good.getId()}">В корзину</button>
            </div>
            </form:form>
    </div>

    </c:if>
       </c:forEach>
    </div>
    <div class="header_category">
        <p class="text_category">Мотоциклы</p>
    </div>
    <div class="category" id="moto">
    <c:forEach items="${goods}" var="good">

        <c:if test="${good.getCat() eq 'moto'}">

        <br>
        <div class="products" id="${good.getId()}">
        <div class="img"><img src=${pageContext.request.contextPath}/resources/${good.getImg()}></img>
        <p>${good.getName()}
        <br></p></div><div class="text_product">USD ${good.getPrice()}</div>
        <form:form modelAttribute="user" method="post" action="basket" >
                <div><button class="button" name="basket" value="${good.getId()}" <input type="submit" id="${good.getId()}">В корзину</button>
                </div>
                </form:form>
        </div>

        </c:if>
           </c:forEach>
    </div>
    <footer class="footer">
        <a href="registration.html" target="_self" id="text_footer">Зарегистрироваться</a>
        <p id="text_footer">
            Stolbov production
        </p>
    </footer>

    <div id="popup_name" class="popup_block">
        <h2>Поиск</h2>
        <form:form modelAttribute="user" method="post" action="search" >
            <p><input type="search" name="quest" placeholder="Название товара.." autofocus class="search1" value=""></p>
            <p><input type="submit" value="Найти" class="submit1"></p>
        </form:form>
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

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/showsGoods.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/genBask.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modal.js"></script>

</body>

</html>