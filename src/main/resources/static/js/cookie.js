
function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
{
    var Days = 300; //此 cookie 将被保存 30 天
    var exp  = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

/*function delCookie(name)//删除cookie：把对应的值改成空
{
    SetCookie(name, "");
}*/
function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}
//判断用户是否失效
function  loginFlag(){
    var userName=getCookie("userName");
    var userId=getCookie("userId");
    if(userName==null || userId==null){
        alert("请重新登陆！");
        var url =window.location.host;
        window.location.href="http://"+url;
    }
}
