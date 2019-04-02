window.onload=function () {
    var userName =document.getElementById("userName");
    userName.focus();
    //得到项目的名字
    var objectName=getConfigurationByName("projectName");
    var h1=document.getElementById("objectName");
    h1.innerHTML=objectName;
    $("#objectName1").html(objectName);
}
//登陆
function login() {
    var userName=$("#userName").val();
    var password=$("#password").val();
   /* var userName=$("[name='userName']").val();
    var password=$("[name='password']").val();*/
   /* var userName=document.getElementById("userName")
    var password=document.getElementById("password")*/
    if(userName==""){
        alert("请输入用户名！");
        return ;
    }
    if(password==""){
        alert("请输入密码！");
        return ;
    }

    var json={userName:userName,password:password};
    $.ajax({
        url:"/grapeUserController/findAllGrapeUserGrapeUser",
        data:json,
        type:"post",
        success:function (data) {
            if(data.flag==1){
                SetCookie("userName", data.userName);
                SetCookie("userId", data.userId);
                loginDoClean();
                window.location.href="../views/homePage.html";
            }else{
                alert("登陆失败");
            }
        }
    });
}


//回车按钮触发事件
document.onkeyup = function (e) {//按键信息对象以函数参数的形式传递进来了，就是那个e
    var code = e.charCode || e.keyCode;  //取出按键信息中的按键代码(大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的却是charCode)
    if (code == 13) {
        //此处编写用户敲回车后的代码
        login();
    }
}


//登陆的时候需要情况对应的东西
function loginDoClean() {
    //delCookie("userName");
    delCookie("menuURL");
    //delCookie("userId");
    delCookie("configuretionPageNo");
    delCookie("grapeUserPageNo");
}