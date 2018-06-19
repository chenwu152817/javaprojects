<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <a href="/manager/student/index?courseId=${courseInfo.courseId}">添加学生</a>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>课程名</th>
                            <th>学生ID</th>
                            <th>学生姓名</th>
                            <th>平时成绩</th>
                            <th>课程成绩</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list scFormList as scForm>

                            <tr>
                                <td>${courseInfo.courseName}</td>
                                <td>${scForm.studentId}</td>
                                <td>${scForm.studentName}</td>
                                <td><input type="number" id="testGrade${scForm.scId}" value="${scForm.testGrade}"></td>
                                <td><input type="number" id="courseGrade${scForm.scId}" value="${scForm.courseGrade}"></td>
                                <td><a href="/manager/sc/delete?scId=${scForm.scId}&courseId=${courseInfo.courseId}">删除</a></td>
                                <td> <button type="button"  class="btn btn-default btn-primary" id="submit" onclick="save(${scForm.scId})">保存</button></td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
<script>

    function save(scId){
            $.ajax({
                type:"POST",
                url:"/manager/sc/savegrade",
                dataType:"json",
                data:{
                    scId:scId,
                    testGrade:$("#testGrade"+scId).val(),
                    courseGrade: $("#courseGrade"+scId).val()
                },
                success:function (data) {
                    console.log(data)
                    if(data.success){
                        $("#testGrade"+scId).val(data.testGrade);
                        $("#courseGrade"+scId ).val(data.courseGrade);
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