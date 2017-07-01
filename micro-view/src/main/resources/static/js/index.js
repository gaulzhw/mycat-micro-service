function oper_detail(value, row) {
    var href = "product.html?id=" + row.id;
    return "<a href=" + href + ">商品详情</a>";
}

function oper_cart(value, row) {
    var href = "cart.html?id=" + row.id;
    return "<a href=" + href + ">加入购物车</a>";
}
