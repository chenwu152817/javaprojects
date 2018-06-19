<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏-->
        <#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/manager/course/create">
                        <div class="form-group">
                            <label >课程Id</label>
                            <input name="courseId" type="text" class="form-control" value="${(courseInfo.courseName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>课程名</label>
                            <input name="courseName" type="text" class="form-control" value="${(courseInfo.courseName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>课程介绍</label>
                            <input name="courseIntro" type="text" class="form-control" value="${(courseInfo.courseName)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>