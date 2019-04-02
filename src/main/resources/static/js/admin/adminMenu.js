
$(document).ready(function(){
    window.onload=function () {
        getAdminMenu();
    }
//这个必须有，但是没有用，鸡肋
    $("#menuList").treeview({
        toggle: function() {
        }
    });

    //通过点击某个菜单，获取这个菜单的属性
    getMenu=function(menuId){
        menuInfoByMenuId(menuId);
    }
    //通过menuid获取菜单信息
    function menuInfoByMenuId(menuId){
        var json ={menuId:menuId};
        $.ajax({
            url:"/menuControll/getMenuList",
            data:json,
            type:"post",
            success:function (data) {
                $("[name='menuId']").val(menuId);
                $("[name='menuName']").val(data[0].menuName);
                $("[name='flag']").each(function(){
                    if($(this).val() == data[0].flag){
                        $(this).prop( "checked", true );
                    }
                });
                $("[name='parentMenuId']").val(data[0].parentMenuId);
                $("[name='menuLevel']").val(data[0].menuLevel);
                $("[name='menuUrl']").val(data[0].menuUrl);
                $("[name='mean']").val(data[0].mean);
            }
        });
    }
    //更新菜单
    updateMenu=function () {
        var  menuId= $("[name='menuId']").val();
        var menuName = $("[name='menuName']").val();
        var  flag= $("[name='flag']:checked").val();
        var  parentMenuId= $("[name='parentMenuId']").val();
        var  menuLevel= $("[name='menuLevel']").val();
        var menuUrl = $("[name='menuUrl']").val();
        var  mean= $("[name='mean']").val();
        var json ={menuId:menuId,menuName:menuName,flag:flag,parentMenuId:parentMenuId,menuLevel:menuLevel,menuUrl:menuUrl,mean:mean};
        $.ajax({
            url:"/menuControll/updateMenu",
            data:json,
            type:"post",
            success:function (data) {
                //alert("修改成功！");
                func("修改菜单成功！");
            },error:function () {
                //alert("修改失败！");
                func("修改菜单失败！");
            }
        });
    }
//得到菜单名字
    function getAdminMenu() {
        var userName=getCookie("userName");
        var userId=getCookie("userId");
        var json={};
        $.ajax({
            url:"/menuControll/getMenuList",
            data:json,
            type:"post",
            success:function (data) {
                var str="";
                for (var i = 0; i < data.length; i++) {
                    if(data[i].menuLevel==1){
                        str+="<li  value=\""+data[i].menuId+"\" >  <span class=\"folder\" onclick=getMenu(\""+data[i].menuId+"\")>"+data[i].menuName+"</span><ul>";
                        for (var j = 0; j < data.length; j++) {
                            if(data[j].menuLevel==2 && data[j].parentMenuId == data[i].menuId){
                                str+="<li  value=\""+data[j].menuId+"\"> <span class=\"folder\" onclick=getMenu(\""+data[j].menuId+"\")>"+data[j].menuName+"</span></li>";
                            }
                        }
                        str+="</ul></li>";
                    }
                }
                $("#menuList").append(str);
            }
        });
    }

});


// 弹出框淡入淡出
function func(value){
    // 创建一个div
    var layer=document.createElement("div");
    // 设置div的id值
    layer.id="layer";
    /* 创建div的样式，宽200px,高80px，下面的是css样式居中，
     * css样式居中具体了解链接：https://blog.csdn.net/A_Bear/article/details/80546181
     */
    var style={
        background:"#9BA0A0",
        position:"absolute",
        zIndex:10,
        width:"200px",
        height:"80px",
        left:"50%",
        top:"5%",
        marginLeft:"-100px",
        marginTop:"-40px"
    }
    for(var i in style)
        layer.style[i]=style[i];

    // 当找不到id为layer的控件时
    if(document.getElementById("layer")==null){
        // 在body中添加layer控件（layer在上面创建的）
        document.body.appendChild(layer);
        // 设置显示类容
        layer.innerHTML=value;
        // 将div中文本居中
        layer.style.textAlign="center";
        layer.style.lineHeight="80px"; // 作用是调节字体行高与div同高，使其保持水平居中
        // 设置3s后去掉弹出窗
        setTimeout("document.body.removeChild(layer)",3000)
    }
}