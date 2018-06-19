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
                            <th>课程序号</th>
                            <th>课程名</th>
                            <th>教师ID</th>
                            <th>课程介绍</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="4">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list courseInfoList as courseInfo>
                            <tr>
                                <td>${courseInfo.courseId}</td>
                                <td>${courseInfo.courseName}</td>
                                <td>${courseInfo.teacherId}</td>
                                <td>${courseInfo.courseIntro}</td>
                                <td>${courseInfo.createTime}</td>
                                <td>${courseInfo.updateTime}</td>
                                <td><a href="/manager/course/index?courseId=${courseInfo.courseId}">修改</a></td>
                                <td><a href="/manager/course/detaillist?courseId=${courseInfo.courseId}">详情</a></td>
                                <td><a href="/manager/check/list?courseId=${courseInfo.courseId}">点名详情</a></td>
                                <td><a href="/manager/homework/list?courseId=${courseInfo.courseId}">作业详情</a></td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>