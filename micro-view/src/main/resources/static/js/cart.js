$('.cart_table').bootstrapTable({
    url: "/cart/records",
    method: "GET",
    columns: [{
        field: 'productId',
        title: 'ID'
    }, {
        field: 'productName',
        title: '商品名称'
    }, {
        field: 'productName',
        title: '商品价格'
    }, {
        formatter: 'time_formatter',
        title: '时间'
    }, {
        field: "count",
        title: '数量'
    }],
    responseHandler: handler
});

function handler(res) {
    if (res == undefined) {
        return res;
    }
    var directUrl = res.redirect;
    if (directUrl != undefined) {
        navi2page(directUrl);
        return "[]";
    }
    return res;
}

function time_formatter(value, row) {
    var datetime = new Date(parseInt(row.time));
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}
