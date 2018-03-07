<#include "../header.ftl">
<#include "../top_bar.ftl">
<div class="container-fluid">
    <div class="row">
        <#include "../side_bar.ftl">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">产品添加</h2>
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">产品名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputEmail3" placeholder="产品名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">产品名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputEmail3" placeholder="产品名称">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function login()
    {
        $.ajax({
            type: 'POST',
            url: '/manage/login/post',
            data: $('form[name=login_form]').serialize(),
            success: function(res){
                alert(res.message);
            },
            error: function(xhr) {
                alert('请求失败');
            }
        });
    };
</script>
<#include "../footer.ftl">