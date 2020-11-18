
function gotoProductDetail(id){
    if (DATA.isLogin != "1") {
        alert("未登录")
        //return false;
    }
    //alert(id)
    DATA.productId = id;
    DATA.nextPage = "productDetail";
    vm.setData();
    forward();
}

