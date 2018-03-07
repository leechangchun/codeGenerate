<#include "header.ftl">
<div class="panel panel-default login">
    <div class="panel-heading">管理员登录</div>
    <div class="panel-body">
        <form class="form-horizontal" name="login_form">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="username" placeholder="用户名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">密码</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control"  name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="button" class="btn btn-default" onclick="login()">登录</button>
                </div>
            </div>
        </form>

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
                if(res.error == 0) {
                    location.href = '/manage/';
                }else{
                    alert(res.message);
                }
            },
            error: function(xhr) {
                alert('请求失败');
            }
        });
    };
</script>
<#include "footer.ftl">