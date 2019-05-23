window.onload=function () {
    //sessionStorage 是HTML5新增的一个会话存储对象，用于临时保存同一窗口(或标签页)的数据 暂时没有用到
    //var grapeUser=sessionStorage.getItem("grapeUser");
    //alert(grapeUser);
    var url="home/home.html";
    var menuURL=getCookie("menuURL");
    if(menuURL!="" && menuURL!=null){
        url=menuURL;
    }
    $('#bodyIframe').attr('src', url);
    var objectName=getConfigurationByName("projectName");
    $("#objectName").html(objectName);
    var userName=getCookie("userName");
    var userId=getCookie("userId");
    loginFlag();

    /* $("#userName").text(userName);*/
    var h1=document.getElementById("userName");
    h1.innerHTML=userName;
    var json={flag:"1",userId:userId};
    $.ajax({
        url:"/menuControll/getMenuList",
        data:json,
        type:"post",
        success:function (data) {
           for (var i = 0; i < data.length; i++) {
               if(data[i].menuLevel==1){
                   var shouYeFlag="";
                   if(data[i].menuName =='首页'){
                       shouYeFlag ="onclick='getUrl("+data[i].menuId+",\""+data[i].menuUrl+"\")'";
                   }
                   $("#menus").append("<li id='"+data[i].menuId+"' class='dropdown'> <a href='#'   data-toggle='dropdown' "+shouYeFlag+" >" +data[i].menuName+"</a> </li>");
                   //$("#menus").append("<li id='"+data[i].menuId+"' class='dropdown'> <a href='#' >"+data[i].menuName+"</a> </li>");
                   var str="";
                   for (var j = 0; j < data.length; j++) {
                       if(data[j].menuLevel==2 && data[j].parentMenuId == data[i].menuId){
                           var url =data[j].menuUrl;
                            str+="<li id='"+data[j].menuId+"' onclick='getUrl("+data[j].menuId+",\""+url+"\")'> <a href='#'>"+data[j].menuName+"</a></li>";
                           //$("#"+data[i].menuId).append("<ul class=\"dropdown-menu\"> <li id='"+data[j].menuId+"' > <a href=\"#\">"+data[j].menuName+"</a> </li></ul>")  //OK
                       }
                   }
                   if(str != ""){
                       $("#"+data[i].menuId).append("<ul class='dropdown-menu'>" +str+"</ul>");
                   }

               }

            }
        }
    });
}

//获取iframe的新路径
function getUrl(menuId,menuUrl){
    var iframe =document.getElementById("bodyIframe");
    SetCookie("menuURL",menuUrl+".html");
    iframe.src=menuUrl+".html";
}

/*function getCookie(name)//取cookies函数
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return (arr[2]); return null;

}*/


//onresize响应事件处理中，获取到的页面尺寸参数是变更后的参数。
/*window.onresize=function(){
    changeFrameHeight();
}

function changeFrameHeight(){
    var ifm= document.getElementById("bodyIframe");

    ifm.height=document.documentElement.clientHeight-56;
}*/

function exit() {
    if(confirm("确定退出吗？")){
        delCookie("userName");
        delCookie("menuURL");
        delCookie("userId");
        delCookie("configuretionPageNo");
        delCookie("grapeUserPageNo");
        var exit =document.getElementById('exit');
        exit.setAttribute("href","../");
    }
}

