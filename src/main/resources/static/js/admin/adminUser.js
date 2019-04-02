window.onload=function () {
    var pageNo=1;
    if(getCookie("grapeUserPageNo")!=null && getCookie("grapeUserPageNo")!=""){
        pageNo=getCookie("grapeUserPageNo");
    }
    getAdminUserByPageNo(pageNo);
    getCount(pageNo);
}

//加载所有用户
function getAdminUserByPageNo(pageNo){
    var json ={"pageNo":pageNo};
    $.ajax({
        url:"/grapeUserController/getGrapeUserList",
        data:json,
        type:"post",
        success:function (data) {
            /*getUserByUserId(data[0].userId);
            getAdminMenu(data[0].userId);*/
            var str="";
            var flag="";
            var flag1="";
            for(var i =0;i<data.length;i++){
                var date=timeFormatter(data[i].createdate);
                flag=data[i].flag;
                if(flag=="1"){
                    flag1="在用";
                }else{
                    flag1="停用";
                }
                str+="<tr onclick='getUser("+data[i].userId+")'><td>"+data[i].userName+"</td><td>"+date+"</td><td>"+flag1+"</td></tr>";
            }
            str+="<tr><td></td><td></td><td></td></tr>";
            $("#adminUserList").html(str);
        },error:function () {
            //alert("获取用户信息失败！");
            func("获取用户信息失败！");
        }
    });
}

//通过点击某个用户，获取这个菜单的属性
getUser=function(userId){
    getUserByUserId(userId);
}
//通过userid得到用户信息
function getUserByUserId(userId){
    var json ={userId:userId};
    $.ajax({
        url:"/grapeUserController/getGrapeUserList",
        data:json,
        type:"post",
        success:function (data) {
            $("[name='userId']").val(data[0].userId);
            $("[name='userName']").val(data[0].userName)
            $("[name='flag']").each(function(){
                if($(this).val() == data[0].flag){
                    $(this).prop( "checked", true );
                }
            });
            $("[name='password']").val(data[0].password);
            var date=timeFormatter(data[0].createdate);
            $("[name='createdate']").val(date);
            getAdminMenu(userId);
        }
    });
}

//通过用户id获取用户的权限
/*function getPowerByUserId(userId){
    var json ={userId:userId};
    $.ajax({
        url:"/powerControll/getPowerList",
        data:json,
        type:"post",
        success:function (data) {
            return data;
        },error:function () {
            alert("获取用户权限失败！");
            return ;
        }
    });
}*/

//获取全部菜单+通过用户id获取用户的权限
function getAdminMenu(userId) {
    var menuJson ={flag:2};
    var powerJson ={userId:userId,flag:1};
    $.ajax({
        url:"/menuControll/getMenuList",
        data:menuJson,
        type:"post",
        success:function (data) {
            $.ajax({
                url:"/powerControll/getPowerList",
                data:powerJson,
                type:"post",
                success:function (result) {
                    var str="";
                    for(var i =0;i<data.length;i++){
                        if(data[i].flag==2){
                            str+="<input type='checkbox' name='menuList' value='"+data[i].menuId+"'";
                            for(var j =0;j<result.length;j++){
                                if(result[j].menuId==data[i].menuId){
                                    str+=" checked ";
                                }
                            }
                            str+=">"+data[i].menuName+"&nbsp;&nbsp;</input>";
                        }
                    }
                    $("#powerCheckBox").html(str);
                },error:function () {
                    //alert("获取用户权限失败！");
                    func("获取用户权限失败！");
                }
            });
        },error:function () {
            func("获取菜单失败！");
          //alert("获取菜单失败！");
        }
    });
}

//修好用户资料和用户权限
updateGrapeUser=function(){
    var obj = document.getElementsByName("menuList");
    var powerListByUserId = [];
    for(k in obj){
        if(obj[k].checked)
            powerListByUserId.push(obj[k].value);
    }
    var  flag= $("[name='flag']:checked").val();
    var  userName= $("[name='userName']").val();
    var password = $("[name='password']").val();
    var userId = $("[name='userId']").val();
    var json ={flag:flag,password:password,userId:userId,powerListByUserId:powerListByUserId,userName:userName};
    $.ajax({
        url:"/grapeUserController/updateGrapeUser",
        data:json,
        type:"post",
        success:function (data) {
            //alert("修改用户信息成功！");
            func("修改用户信息成功！");
            var pageNo=1;
            if(getCookie("grapeUserPageNo")!=null && getCookie("grapeUserPageNo")!=""){
                pageNo=getCookie("grapeUserPageNo");
            }
            getAdminUserByPageNo(pageNo);
            getUserByUserId(userId);
        },error:function () {
            func("修改用户数据失败！");
            //alert("修改用户数据失败！");
        }
    });
}

//点击重置，还原
chongZhi=function () {
    var userId=$("[name='userId']").val();
    getUserByUserId(userId);
}

//得到分页
function getCount(pageNo) {
    var json = {pageNo:pageNo};
    var str = "";
    $.ajax({
        url: '/grapeUserController/getConfiguretionSumNum',
        data: json,
        type: 'post',
        success: function (data) {
            if(data.pageNo!=1){
                str+="<li class='page-item'><a class='page-link' href='#' onclick='fenYeFunction("+1+")'>首页</a></li>"+
                    "<li class='page-item'><a class='page-link' href='#' onclick='fenYeFunction("+(data.pageNo-1)+")'>上一页</a></li>"
            }
            if(data.pageNo!=data.totalPage){
                str+="<li class='page-link'><a class='page-link' href='#' onclick='fenYeFunction("+(data.pageNo+1)+")'>下一页</a></li>"+
                    "<li class='page-link'><a class='page-link' href='#' onclick='fenYeFunction("+data.totalPage+")'>末页</a></li>";
            }
            str+="<li class='page-item'><a class='page-link'>当前页"+data.pageNo+" 共"+data.totalPage+"页</a></li>";
            $("#fenYe").html(str);
        }, error: function () {
            //alert("获取数据失败");
            func("获取数据失败！");
        }
    });
}

//分页跳转
fenYeFunction=function(pageNo){
    SetCookie("grapeUserPageNo",pageNo);
    getAdminUserByPageNo(pageNo)
    getCount(pageNo);
}

//校验用户权限(就是更新一下power，把用户没有数据的添加上)
checkPowerEveryOne=function(){
    var json={};
    $.ajax({
        url:"/grapeUserController/checkPowerEveryOne",
        data:json,
        type:"post",
        success:function (data) {
            if(data>0){
                //alert("校验成功！");
                func("校验成功！");
            }
        },error:function () {
            func("校验用户用户失败！");
            //alert("校验用户用户失败！");
        }

    });
}
//创建用户 只需要用户名：
newUser=function () {
    var userName=prompt("请输入创建用户的名字！");
    if(userName==null || userName==""){
        //alert("请填写用户名！");
        //func("请填写用户名！");
        return;
    }
    var json={userName:userName};
    $.ajax({
        url:"/grapeUserController/newUser",
        data:json,
        type:"post",
        success:function (data) {
            if(data>0){
                //alert("添加用户成功！");
                func("添加用户成功！");
            }
        },error:function () {
            //alert("添加用户失败！");
            func("添加用户失败！");
        }

    });
}
//日期格式转换
function timeFormatter(value) {
    var da = new Date(value.replace("/Date(", "").replace(")/" , "").split( "+")[0]);
    return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
}




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