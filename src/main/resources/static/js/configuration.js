//全局变量
var objectName="";
//通过配置项名字过去配置项的参数
function getConfigurationByName(configName){
    var json={servletContext:configName};
    $.ajax({
        url:"/configuretionController/getConfigurationByName",
        data:json,
        async:false,
        type:"post",
        success:function (data) {
            objectName=data;
        },error:function () {
            objectName= "没有获取到参数";
        }
    });

    return objectName;
}
/*
function getConfigurationByName(configName){
   var json={servletContext:configName};
    $.ajax({
        url:"/MVCConfiguration/getConfiguration",
        data:json,
        async:false,
        type:"post",
        success:function (data) {
            objectName=data;
        },error:function () {
            objectName= "没有获取到参数";
        }
    });
    return objectName;
}*/
