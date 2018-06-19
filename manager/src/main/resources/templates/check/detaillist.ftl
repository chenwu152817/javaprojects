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
                            <th>点名记录</th>
                            <th>学生ID</th>
                            <th>到课状态</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                            <#list checkDetailPage.content as checkDetail>
                            <tr>
                                <td>${checkDTO.checkIntro}</td>
                                <td>${checkDetail.studentId}</td>
                                <td>
                                    <#if checkDetail.checkStatus == 0>
                                        到课
                                    <#else>
                                        缺课
                                    </#if>
                                </td>
                                <td>
                                            <#if checkDetail.checkStatus == 0>
                                                <a href="/manager/check/absent?checkDetailid=${checkDetail.checkDetailid}&checkId=${checkDTO.checkId}&page=${currentPage}">缺课</a>
                                            <#else>
                                                 <a href="/manager/check/present?checkDetailid=${checkDetail.checkDetailid}&checkId=${checkDTO.checkId}&page=${currentPage}">到课</a>
                                            </#if>
                                </td>
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
                    <li ><a href="/manager/check/detaillist?checkId=${checkDTO.checkId}&page=${currentPage-1}&size=2">上一页</a></li>
                    </#if>
                    <#list 1..checkDetailPage.getTotalPages() as index>
                        <#if currentPage==index>
                        <li class="disabled" ><a href="#">${index}</a></li>
                        <#else >
                        <li><a href="/manager/check/detaillist?checkId=${checkDTO.checkId}&page=${index}&size=2">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte checkDetailPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                    <li ><a href="/manager/check/detaillist?checkId=${checkDTO.checkId}&page=${currentPage+1}&size=2">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>