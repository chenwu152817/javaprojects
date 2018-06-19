<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>作业记录</th>
                            <th>学生ID</th>
                            <th>作业成绩</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list homeworkDetailPage.content as homeworkDetail>
                            <tr>
                                <td>${homeworkDTO.homeworkIntro}</td>
                                <td>${homeworkDetail.studentId}</td>
                                <td>
                                    <input type="number" id="homeworkGrade${homeworkDetail.homeworkDetailid}" value="${homeworkDetail.homeworkGrade}">
                                </td>
                                <td> <button type="button"  class="btn btn-default btn-primary" id="submit" onclick="save(${homeworkDetail.homeworkDetailid})">保存</button></td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                    <#else >
                    <li ><a href="/manager/homework/detaillist?homeworkId=${homeworkDTO.homeworkId}&page=${currentPage-1}&size=2">上一页</a></li>
                    </#if>
                    <#list 1..homeworkDetailPage.getTotalPages() as index>
                        <#if currentPage==index>
                        <li class="disabled" ><a href="#">${index}</a></li>
                        <#else >
                        <li><a href="/manager/homework/detaillist?homeworkId=${homeworkDTO.homeworkId}&page=${index}&size=2">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte homeworkDetailPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                    <li ><a href="/manager/homework/detaillist?homeworkId=${homeworkDTO.homeworkId}&page=${currentPage+1}&size=2">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
<script>

    function save(homeworkDetailid){
        $.ajax({
            type:"POST",
            url:"/manager/homework/savegrade",
            dataType:"json",
            data:{
                homeworkDetailid:homeworkDetailid,
                homeworkGrade:$("#homeworkGrade"+homeworkDetailid).val()
            },
            success:function (data) {
                console.log(data)
                if(data.success){
                    $("#homeworkGrade"+homeworkDetailid).val(data.homeworkGrade);
                    alert("保存成功");
                }else{
                    alert("发生错误："+ data.msg);
                }
            },
            error:function (jqXHR) {
                alert("发生错误：" +jqXHR.status);
            }
        })
    }

</script>
</body>
</html>