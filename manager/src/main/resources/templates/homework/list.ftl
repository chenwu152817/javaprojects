<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <a href="/manager/homework/index?courseId=${courseInfo.courseId}">创建作业</a>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>课程序号</th>
                            <th>课程名</th>
                            <th>作业记录</th>
                            <th>创建时间</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list homeworkDTOList as homeworkDTO>
                            <tr>
                                <td>${courseInfo.courseId}</td>
                                <td>${courseInfo.courseName}</td>
                                <td>${homeworkDTO.homeworkIntro}</td>
                                <td>${homeworkDTO.createTime}</td>
                                <td><a href="/manager/homework/detaillist?homeworkId=${homeworkDTO.homeworkId}">作业详情</a></td>
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