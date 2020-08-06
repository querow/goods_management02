<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>出库了</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
        <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

    <div class="layui-fluid">
        <div class="layui-row">
            <form class="layui-form" form>
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                        <span class="x-red">*</span>商品编号：
                    </label>
                    <div class="layui-input-inline">
                        <input type="hidden" name="id" value="${store.storeId}"/>
                        <span>${store.storeId}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                        <span class="x-red">*</span>商品名称：
                    </label>
                    <div class="layui-input-inline">
                        <span>${store.storeName}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>库存数量：
                    </label>
                    <div class="layui-input-inline">
                        <span id="num">${store.num}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                        <span class="x-red">*</span>库存上限：
                    </label>
                    <div class="layui-input-inline">
                        <span>${store.uNum}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                        <span class="x-red">*</span>库存下限：
                    </label>
                    <div class="layui-input-inline">
                        <span>${store.dNum}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                        <span class="x-red">*</span>状态：
                    </label>
                    <div class="layui-input-inline">
                        <span>${store.state}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="outNumber" class="layui-form-label">
                        <span class="x-red">*</span>出库数量：
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" placeholder="请输入出库数量" id="outNumber" name="outNumber" required="" lay-verify="required"
                               autocomplete="off" class="layui-input" onchange="checkNumber()"/>
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>出库数量必须小于库存数量
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="add" class="layui-form-label">
                    </label>
                    <input type="submit" id="add" value="提交" class="layui-btn" lay-filter="add" lay-submit="" />

                </div>
            </form>
        </div>
    </div>
    </body>
    <script>
        layui.use(['form', 'layer'],
        function() {
            $ = layui.jquery;
            var form = layui.form,
                layer = layui.layer;

            //监听提交
            form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    $.ajax({
                        url:"${pageContext.request.contextPath}/store/outStore.do",
                        type:"get",
                        data:data.field,
                        success:function(){
                            layer.alert("出库成功", {
                                    icon: 6
                                },
                                function() {
                                    //关闭当前frame
                                    xadmin.close();

                                    // 可以对父窗口进行刷新
                                    xadmin.father_reload();
                                });
                        }
                    })

                    return false;
                });

        });
        function checkNumber(){
            var outNumberStr = $("#outNumber").val();
            var outNumber = Number(outNumberStr);
            if(outNumber>${store.num}){
                alert("出库数量错误");
            }
        }
    </script>
</html>
