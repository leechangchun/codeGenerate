<#include "../header.ftl">
<#include "../top_bar.ftl">
<div class="container-fluid">
    <div class="row">
        <#include "../side_bar.ftl">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">topic添加</h2>
            <form class="form-horizontal" name="add_form">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="name"  placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">banner</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="banner"  placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">slogen</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="slogen"  placeholder="">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" onclick="post()" class="btn btn-primary">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
 <script type="text/javascript">
     function post()
     {
         $.ajax({
             type: 'POST',
             url: '/manage/topic/add/post',
             data: $('form[name=add_form]').serialize(),
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