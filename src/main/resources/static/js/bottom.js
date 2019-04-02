window.onload=function () {
    var objectName = getConfigurationByName("projectName");
    $("#objectName").html(objectName);
    var company = getConfigurationByName("company");
    var projectNo = getConfigurationByName("projectNo");
    var companyPhone = getConfigurationByName("companyPhone");
    $("#bottom").html("公司名称：" + company + "  版本号：" + projectNo + "  联系方式：" + companyPhone);
}
