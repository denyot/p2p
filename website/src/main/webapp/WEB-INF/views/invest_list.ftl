<#if pageResult.result?size &gt; 0 >
    <#list pageResult.result as data>
    <tr>
        <td>${data.createUser.username }</td>
        <td>${data.title}</td>
        <td class="text-info">${data.currentRate}%</td>
        <td class="text-info">${data.bidRequestAmount}</td>
        <td>${data.returnTypeDisplay}</td>
        <td>
            <div class="">
            ${data.persent} %
            </div>
        </td>
        <td><a class="btn btn-danger btn-sm"
               href="/borrow_info?id=${data.id}">查看</a></td>
    </tr>
    </#list>
<script type="text/javascript">
    $(function () {
        $("#pagination_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));
        $("#pagination").twbsPagination({
            totalPages:${pageResult.totalPage},
            startPage:${pageResult.currentPage},
            onPageClick: function (event, page) {
                $("#currentPage").val(page);
                $("#searchForm").submit();
            }
        });
    });
</script>
<#else>
<tr>
    <td colspan="7" align="center">
        <p class="text-danger">目前没有符合要求的标</p>
    </td>
</tr>
<script type="text/javascript">
    $(function () {
        $("#pagination_container").empty();
    });
</script>
</#if>