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
                    <form role="form" method="post" action="/manager/check/save">
                        <input hidden name="courseId" type="text" value="${(courseInfo.courseId)}" />
                        <div class="form-group">
                            <label>点名描述</label>
                            <input name="checkIntro" type="text" class="form-control" />
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