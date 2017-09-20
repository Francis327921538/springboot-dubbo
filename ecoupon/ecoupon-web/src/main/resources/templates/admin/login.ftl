<!DOCTYPE html>
<html>

<style>
    body,h1,h2,h3,h4,h5,h6,p,ul,li,a,small,span,label{font-family:'微软雅黑';}
    .lbl {
        position: relative;
        display: inline-block;
        margin: 0 0 0 128px;
        line-height: 40px;
        min-height: 18px;
        min-width: 18px;
        font-weight: normal;
        cursor: pointer;
    }
    .pos-rel, .position-relative {
        margin-left: 200px;
        margin-right: -150px;
        margin-top:20%;
    }
    .header.blue {
        border-bottom: 0;
    }
    .widget-main>form {
        margin-bottom: 0;
        /*   margin-top: 32px; */
    }
    h4.bigger {
        font-size: 20px !important;
        font-family: '微软雅黑';
        color: #454545 !important;
    }
    .input-icon.input-icon-right>input{width:270px;height:48px;}
    .input-icon.input-icon-right>input {
        padding-left: 40px !important;
        font-size: 14px;
        font-family: '微软雅黑';
        font-weight: 100;
    }
    .errinfo{color:#ff2d2d;}
    .errinfo img{margin-right:5px;margin-top:-3px;}
    .input-icon > .img-icon {
        z-index: 2;
        position: absolute;
        top: 14px;
        bottom: 1px;
        left: 3px;
        line-height: 30px;
        display: inline-block;
        color: rgb(144, 144, 144);
        font-size: 16px;
        padding: 0px 9px;
    }
    .login-box {width:350px; height:414px;}
    .padd0{padding:0px !important;}
    .login-container{width:700px !important;min-width:700px; height:414px !important;}
    .login-layout .login-box .widget-main{height:414px !important; margin-left:30px;padding-top:40px;}
    .width-92 {   width: 92%!important; height:48px;}
    .mart11{margin-top:22px;}
    .btn-pria{background-color:#e2ecff !important; border:1px solid #9bbaf2;font-size:18px; font-family:'微软雅黑'; color:#464646; }
    .btn-pria:hover,.btn-pria:focus{background-color:#4784f5 !important;border:1px solid #4784f5;color:#fff;}
    /* .btntext{font-size:18px; font-family:'微软雅黑'; color:#464646;} */
    .input-icon.input-icon-right>input:focus{border-color:#4784f5}
    .align2 input{display:block; float:left; margin-right:4px;  border: #3e97eb; background: #3e97eb;}
    .align2 span{display:block; float:left; height:20px; line-height:20px; *line-height:22px;}

    .demo{width:360px; margin: -30px auto 0px -10px;padding:10px;}
    .demo img{width:90%}
    .demo h3{font-size:1.5em;line-height:1.9em}
    .col{margin-top:20px}
    .col h4{height:40px;line-height:40px}
    .opt{height:30px;/* line-height:24px */}
    .magic-radio,
    .magic-checkbox {
        position: absolute;
        display: none; }
    .magic-radio + label,
    .magic-checkbox + label {
        position: relative;
        display: block;
        padding-left: 30px;
        cursor: pointer;
        vertical-align: middle; }
    .magic-radio + label:before,
    .magic-checkbox + label:before {
        position: absolute;
        top: 0;
        left: 0;
        display: inline-block;
        width: 20px;
        height: 20px;
        content: '';
        border: 1px solid #c0c0c0; }
    .magic-radio + label:after,
    .magic-checkbox + label:after {
        position: absolute;
        display: none;
        content: ''; }
    .magic-radio:checked + label:after,
    .magic-checkbox:checked + label:after {
        display: block; }
    .magic-checkbox + label:before {
        border-radius: 3px; }
    .magic-checkbox + label:after {
        top: 2px;
        left: 7px;
        box-sizing: border-box;
        width: 6px;
        height: 12px;
        transform: rotate(45deg);
        border-width: 2px;
        border-style: solid;
        border-color: #fff;
        border-top: 0;
        border-left: 0; }
    .magic-checkbox:checked + label:before {
        border: #3e97eb;
        background: #3e97eb; }
</style>
<#include  "/header/head.ftl"/>
<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-9 col-xs-9 col-md-9 col-lg-9"><!--col-sm-offset-1  -->
                <div class="login-container">


                    <div class="space-6"></div>

                    <div class="position-relative col-sm-12 col-xs-12 col-md-12 col-lg-12 padd0">
                        <div class="col-sm-6 col-xs-6 col-md-6 col-lg-6 padd0">
                            <img src="ace_assets/images/apply/loglogoim.jpg" width="350" height="414">
                        </div>
                        <div id="login-box"	class="login-box visible  no-border col-sm-6 col-xs-6 col-md-6 col-lg-6 padd0">
                            <div class="widget-body">
                                <div class="widget-main" id="app">
                                    <h4 class="header blue lighter bigger">
                                        <!-- <i class="ace-icon fa fa-user green"></i> -->
                                        管理员登录
                                    </h4>
                                    <!-- 登录失败提示 -->
                                    <!-- <div class="errinfo" v-show="isShowErrorInfo">
                                     <img src="{basePath}ace_assets/images/apply/merror.png" width="13" height="13"><label>您输入的用户或密码错误！</label>
                                 </div>  -->

                                    <form >
                                        <fieldset>
                                            <label class="block clearfix"> <span
                                                    class="block input-icon input-icon-right">
                                                     <img class="img-icon" src="{basePath}ace_assets/images/apply/user.png" />
                                                     <input v-model="username" type="text" class="form-control" name="username"
                                                            placeholder="用户名" /> <!-- <i class="ace-icon fa fa-user"></i> -->
												</span>
                                            </label>
                                            <label class="block clearfix mart11">
												<span class="block input-icon input-icon-right">
													<img class="img-icon" src="{basePath}ace_assets/images/apply/pwd.png" />
													<input v-model="password"	type="password" class="form-control" name="password"
                                                           placeholder="密码" /> <!-- <i class="ace-icon fa fa-lock"></i> -->
												</span>
                                            </label>



                                            <div id="main">
                                                <div class="demo">
                                                    <div class="col">
                                                        <div class="opt">
                                                            <input class="magic-checkbox" type="checkbox" v-model="checked"  name="rememberPassword" id="c1" >
                                                            <label for="c1">记住密码</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                    <div class="space-6"></div>
                                    <div  class="clearfix">
                                        <button type="button" @click="submitForm()"
                                                class="width-92  btn-pria">
                                            <!-- <i class="ace-icon fa fa-key"></i> -->
                                            立即登录
                                        </button>
                                    </div>
                                </div>
                                <!-- /.widget-main -->

                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.login-box -->
                    </div>
                    <!-- /.position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->

<!-- basic scripts -->

<#include "/basic-scripts/basic-scripts.ftl"/>

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement)
        document
                .write("<script src='assets/js/jquery.mobile.custom.min.js'>"
                        + "<"+"/script>");
</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($) {
        $(document).on('click', '.toolbar a[data-target]', function(e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    });

    //you don't need this, just used for changing background
    jQuery(function($) {
        $('body').attr('class', 'login-layout light-login');
        $('#id-text2').attr('class', 'grey');
        $('#id-company-text').attr('class', 'blue');
    });
</script>
<!-- Yandex.Metrika counter -->
<!-- <script type="text/javascript">
    (function(d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter25836836 = new Ya.Metrika({
                    id : 25836836,
                    webvisor : true,
                    clickmap : true,
                    trackLinks : true,
                    accurateTrackBounce : true
                });
            } catch (e) {
            }
        });

        var n = d.getElementsByTagName("script")[0], s = d
                .createElement("script"), f = function() {
            n.parentNode.insertBefore(s, n);
        };
        s.type = "text/javascript";
        s.async = true;
        s.src = (d.location.protocol == "https:" ? "https:" : "http:")
                + "//mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else {
            f();
        }
    })(document, window, "yandex_metrika_callbacks");
</script> -->
<!-- <noscript>
    <div>
        <img src="//mc.yandex.ru/watch/25836836"
            style="position: absolute; left: -9999px;" alt="" />
    </div>
</noscript> -->
<!-- /Yandex.Metrika counter -->
<!-- <script>
    (function(i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function() {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o), m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script',
            '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-38894584-2', 'auto');
    ga('send', 'pageview');
</script> -->

<script type="text/javascript">
    var webapi = '{basePath}';
    var myVue = new Vue({
        el: '#app',
        data: {
            username: getCookie("cache_user"),
            password: getCookie("cache_pwd"),
            checked:  eval(getCookie("cache_status")),
            isShowErrorInfo:false
        },
        methods: {
            submitForm: function() {
                var _self = this;
                var _param = {
                    username: _self.username,
                    password: _self.password
                }
                setCookie("cache_user",_self.username,30);
                if(_self.checked){
                    setCookie("cache_pwd",escape(_self.password),30);
                    setCookie("cache_status","true",30);
                }else{
                    setCookie("cache_pwd","",30);
                    setCookie("cache_status","false",30);
                }
//                var formData=new FormData();
//                formData.append("username",_self.username);
//                formData.append("password",_self.password);
                _self.$http.post('/login',  _param)
                        .then(function(response){
                            console.log(response.data)
                            if(response.data.success) {
                                if(window.location.href.indexOf(response.data.entity)==-1) {
                                    window.location.href ="/";
                                } else {
                                    window.location.href = "/";
                                }
                            } else {
                                _self.$message({
                                    type: 'error',
                                    message: response.data.message
                                });
                                isShowErrorInfo=true;
                            }
                        })
            },

        }
    })
    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }

    function setCookie(c_name,value,expiredays)
    {
        var exdate=new Date()
        exdate.setDate(exdate.getDate()+expiredays)
        document.cookie=c_name+ "=" +escape(value)+ ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
    }

    function delCookie(name)
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=getCookie(name);
        if(cval!=null)
            document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    }
</script>
</body>
</html>