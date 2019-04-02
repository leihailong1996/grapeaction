window.onload=function(){
    var pageNo=1;
    if(getCookie("configuretionPageNo")!=null &&getCookie("configuretionPageNo")!=""){
        pageNo=getCookie("configuretionPageNo");
    }
    getListByPageNo(pageNo);
    getCount(pageNo);
}

function getListByPageNo(pageNo){
   var json ={"pageNo":pageNo};
   var str="";
   $.ajax({
        url:'/configuretionController/getConfiguretionList',
        data:json,
        type:'post',
        success:function (data) {
            //刚进来，默认第一个选择
            //getConfigurationById(data[0].configid);
            for(var i =0;i<data.length;i++){
                str+="<tr onclick='getConfigurationById("+data[i].configid+")'><td>"+data[i].configname+"</td><td>"+data[i].configvalue+"</td><td>"+data[i].flag+"</td></tr>";
            }
            str+="<tr><td></td><td></td><td></td></tr>";
            $("#adminConfiguretionList").html(str);
        },error:function () {
            //alert("获取数据失败");
           func("修改配置项失败！");
        }
    });
}

function getCount(pageNo) {
    var json = {pageNo:pageNo};
    var str = "";
    $.ajax({
        url: '/configuretionController/getConfiguretionSumNum',
        data: json,
        type: 'post',
        success: function (data) {
            if(data.pageNo!=1){
                str+="<li class='page-item'><a class='page-link' href='#' onclick='fenYeFunction("+1+","+data.totalPage+")'>首页</a></li>"+
                    "<li class='page-item'><a class='page-link' href='#' onclick='fenYeFunction("+(data.pageNo-1)+","+data.totalPage+")'>上一页</a></li>"
            }
            if(data.pageNo!=data.totalPage){
                str+="<li class='page-link'><a class='page-link' href='#' onclick='fenYeFunction("+(data.pageNo+1)+","+data.totalPage+")'>下一页</a></li>"+
                    "<li class='page-link'><a class='page-link' href='#' onclick='fenYeFunction("+data.totalPage+","+data.totalPage+")'>末页</a></li>";
            }
            str+="<li class='page-item'><a class='page-link'>当前页"+data.pageNo+" 共"+data.totalPage+"页</a></li>";
            $("#fenYe").html(str);
        }, error: function () {
            //alert("获取数据失败");
            func("修改配置项失败！");
        }
    });
}
//分页跳转
fenYeFunction=function(pageNo,totalPage){
    if(pageNo>totalPage){
        SetCookie("configuretionPageNo",totalPage);
        getListByPageNo(totalPage);
        getCount(totalPage);
    }else{
        SetCookie("configuretionPageNo",pageNo);
        getListByPageNo(pageNo);
        getCount(pageNo);
    }


}

//通过配置项id获取到配置项的信息
getConfigurationById =function (configid){
    var json ={configid:configid};
    $.ajax({
        url:'/configuretionController/getConfiguretionList',
        data:json,
        type:'post',
        success:function (data) {
            $("#configname").val(data[0].configname);
            $("#configvalue").val(data[0].configvalue);
            $("#flag").val(data[0].flag);
            $("#mean").val(data[0].mean);
            var date=timeFormatter(data[0].createdate);
            $("#createdate").val(date);
            $("#configid").val(data[0].configid);
        },error:function () {
            func("修改配置项失败！");
            //alert("获取数据失败");
        }
    });

}
//更新配置项
updateCinfigurtion=function () {
    var  configname= $("#configname").val();
    var configvalue = $("#configvalue").val();
    var  flag= $("#flag").val();
    var  mean= $("#mean").val();
    var configid = $("#configid").val();
    var json ={configname:configname,configvalue:configvalue,flag:flag,mean:mean,configid:configid};
    $.ajax({
        url:"/configuretionController/updateConfiguretion",
        data:json,
        type:"post",
        success:function (data) {
            //alert("修改成功！");
            if(configname=='pageSize'){
                location.reload()
            }

            func("修改配置项成功！");
        },error:function () {
            func("修改配置项失败！");
            //alert("修改失败！");
        }
    });
    var pageNo=1;
    if(getCookie("configuretionPageNo")!=null){
        pageNo=getCookie("configuretionPageNo");
    }
    fenYeFunction(pageNo);
}
//点击重置，还原
function chongZhi() {
    var configid=$("#configid").val();
    getConfigurationById(configid);
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