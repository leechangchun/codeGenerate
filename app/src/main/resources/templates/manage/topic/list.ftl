<#include "../header.ftl">
<#include "../top_bar.ftl">
<div class="container-fluid">
    <div class="row">
        <#include "../side_bar.ftl">

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">topic列表</h2>
            <form class="form-inline">
                <a href="/manage/topic/add" class="btn btn-primary">添加topic</a>
            </form>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>banner</th>
                        <th>slogen</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list list as topic>
                    <tr>
                        <th>${topic.id!}</th>
                        <th>${topic.name!}</th>
                        <th>${topic.banner!}</th>
                        <th>${topic.slogen!}</th>
                        <td>
                            <a href="/manage/topic/update?id=${topic.id}">编辑</a>
                            <button type="button" onclick="del(${topic.id})" class="btn btn-primary">删除</button>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
        function del(id)
        {
            $.ajax({
                url: '/manage/topic/delete?id='+id,
                success: function(res){
                    alert(res.message);
                    location.reload();
                },
                error: function(xhr) {
                    alert('请求失败');
                }
            });
        };
</script>
<#include "../footer.ftl">