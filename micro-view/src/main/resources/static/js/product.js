var id = getQueryString(window.location.href, 'id');
var dataUrl = "/product/" + id;

$('#productTable').bootstrapTable({
    url: dataUrl,
    columns: [{
        field: 'id',
        title: 'ID'
    }, {
        field: 'name',
        title: '商品名称'
    }, {
        field: 'price',
        title: '商品价格'
    }, {
        field: 'desc',
        title: '商品描述'
    }, {
        formatter: 'oper_cart',
        title: '加入购物车'
    }]
})
