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
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list studentInfoPage.content as studentInfo>
                            <tr>
                                <td>${courseInfo.courseName}</td>
                                <td>${studentInfo.studentId}</td>
                                <td>${studentInfo.studentName}</td>
                                <td><a href="#">删除</a></td>
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
                    <li ><a href="/manager/course/detaillists?page=${currentPage-1}&size=2&courseId=${courseInfo.courseId}">上一页</a></li>
                    </#if>
                    <#list 1..studentInfoPage.getTotalPages() as index>
                        <#if currentPage==index>
                        <li class="disabled" ><a href="#">${index}</a></li>
                        <#else >
                        <li><a href="/manager/course/detaillists?page=${index}&size=2&courseId=${courseInfo.courseId}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte studentInfoPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                    <li ><a href="/manager/course/detaillists?page=${currentPage+1}&size=2&courseId=${courseInfo.courseId}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>