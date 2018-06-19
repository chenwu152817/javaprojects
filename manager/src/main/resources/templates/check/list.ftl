<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <a href="/manager/check/index?courseId=${courseInfo.courseId}">创建点名</a>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>课程序号</th>
                            <th>课程名</th>
                            <th>点名记录</th>
                            <th>创建时间</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list checkDTOList as checkDTO>
                            <tr>
                                <td>${courseInfo.courseId}</td>
                                <td>${courseInfo.courseName}</td>
                                <td>${checkDTO.checkIntro}</td>
                                <td>${checkDTO.createTime}</td>
                                <td><a href="/manager/check/detaillist?checkId=${checkDTO.checkId}">点名详情</a></td>
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