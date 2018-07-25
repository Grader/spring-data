<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new good
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="cat" placeholder="Введите категорию: auto или moto" />
            </div>
            <div class="form-group">
                            <input type="text" class="form-control" name="tag" placeholder="Введите имя товара" />
                        </div>
                        <div class="form-group">
                                        <input type="text" class="form-control" name="price" placeholder="Введите стоимость" />
                                    </div>
                                    <div class="form-group">
                                                    <input type="text" class="form-control" name="img" placeholder="Введите путь к файлу изображения" />
                                                </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list goods as good>
    <div class="card my-3" id="${good.id}">

        <img src="/static/imgs/${good.img}" class="card-img-top">
        <div class="m-2">
            <span>${good.tag}</span>
            <i>USD ${good.price}</i>
        </div>
        <div class="card-footer text-muted">
            ${good.cat}
        </div>
    </div>


    </#list>
</div>


</@c.page>
