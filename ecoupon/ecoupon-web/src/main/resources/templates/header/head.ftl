
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>系统登录</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="ace_assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="ace_assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		
		<!-- ckeditor 文本编辑器-->
		<script src="ckeditor/ckeditor.js"></script>
		

		<!-- text fonts -->


		<!-- ace styles -->
		<link rel="stylesheet" href="ace_assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="ace_assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="ace_assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="ace_assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="ace_assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="ace_assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="ace_assets/js/html5shiv.min.js"></script>
		<script src="ace_assets/js/respond.min.js"></script>
		<![endif]-->
		
		<!-- easyui css -->
		<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
		<link rel="stylesheet" href="easyui/themes/icon.css" />

	   <link href="https://cdn.bootcss.com/element-ui/1.4.1/theme-default/index.css" rel="stylesheet">
		
		<!-- easyui js -->
	<script src="ace_assets/js/jquery-2.1.4.min.js"></script>
	<script src="ace_assets/js/jquery.media.js"></script>
		<script src="easyui/jquery.easyui.min.js"></script>
		<script src="<%=basePath%>pdfjs/pdf.js"></script>
		<script src="vue/vue.js"></script>
		<script src="<%=basePath%>/vue/vue-upload-component.js"></script>
		<script src="https://cdn.bootcss.com/vee-validate/2.0.0-rc.10/vee-validate.min.js"></script>
		<script src="https://cdn.bootcss.com/vee-validate/2.0.0-rc.10/locale/zh_CN.js"></script>
		<script src="https://cdn.bootcss.com/element-ui/1.4.1/index.js"></script>
		

	 	<script src="vue/axios.min.js"></script>
		<script src="vue/vue-resource.js"></script>
		
		<!-- jquery-ui js -->
			

		
<!-- 		    <script src="https://unpkg.com/vue"></script>
    引入样式
  
    引入组件库
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script> -->
    
    	<script type="text/x-template" id="cpdf">
<div>
<div  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document" style="width:100%">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">{{title}}</h4>
      </div>
      <div class="modal-body" v-show="title.indexOf('.pdf')!=-1">
             <div class="row">
						<div class="col-sm-2" >
							<p  v-if="page_num">Page: <span v-text="page_num"></span> / <span v-text="page_count"></span></p>
                        	<button type="button" @click="prev" class="btn btn-default">上一页</button>
                        	<button type="button" @click="next" class="btn btn-default">下一页</button> 
							<hr>
                        	<button type="button" @click="addscale" class="btn btn-default"><span>放大</span></button>
                        	<button type="button" @click="minus" class="btn btn-default"><span>缩小</span></button>
							<hr>
                        	   <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 	 	</div>
						<div class="col-sm-8">
                  			<canvas class="canvasstyle" style="height:80%" id="the-canvas"></canvas>
				  		</div>
			</div>
      </div>
      <div class="modal-body" v-show="title.indexOf('.pdf')==-1">
             <div class="row">
					<img :src="picUrl">
			</div>
      </div>
      <div class="modal-footer">
      </div>

    </div>
  </div>
</div>

</div>
</script>
    
    <script type="text/javascript">
	var webapi = '';

	Vue.filter('time', function (date, key) {
		if(typeof(key) == 'undefined' || (typeof(key) != 'undefined' && key.indexOf('Time')!=-1)) {
			function getMonth(date){  
		        var month = "";  
		        month = date.getMonth() + 1; //getMonth()得到的月份是0-11  
		        if(month<10){  
		            month = "0" + month;  
		        }  
		        return month;  
		    }  
		    //返回01-30的日期  
		    function getDay(date){  
		        var day = "";  
		        day = date.getDate();  
		        if(day<10){  
		            day = "0" + day;  
		        }  
		        return day;  
		    }
		        var dateTypeDate = "";
		        if(!date){
		        	return '';
		        }
		        var date = new Date(date);  
		        dateTypeDate += date.getFullYear();   //年  
		        dateTypeDate += "-" + getMonth(date); //月   
		        dateTypeDate += "-" + getDay(date);   //日  
		        return dateTypeDate;  
		} else {
			return date
		}
	})
	
	Vue.filter('status',function(data, key){
		if(key == 'auditStatus') {
			switch(data){
				case -1:
					return '未通过';
				case 1:
					return '待审核';
				case 2:
					return '区县审核通过';
				case 3:
					return '第三方审核通过';
				case 4:
					return '市局两创办审核通过';
			}
		}
	
		return data	
		
		
		
		
		
	})
	
	
	
	Vue.prototype.getDate = function () {
		 var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + date.getMinutes()
		            + seperator2 + date.getSeconds();
		    return currentdate;
    }

	var config = {
	    errorBagName: 'errors', // change if property conflicts.
	    delay: 0,
	    locale: 'zh_CN',
	    messages: null,
	    strict: true
	};
	var validator = VeeValidate.Validator;
	
 	Vue.use(VeeValidate,config);
 	Vue.component("cpdf", {
	    template: "#cpdf",
	    props: {
	    	pdfurl: ''
	    },
	    data: function () {
	        return {
	        	 pdfDoc: null, //pdfjs 生成的对象
                 pageNum: 1,//
                 pageRendering: false,
                 pageNumPending: null,
                 scale: 1.2,//放大倍数
                 page_num: 0,//当前页数
                 page_count: 0,//总页数
                 maxscale: 2,//最大放大倍数
                 minscale: 0.8,//最小放大倍数
                 title: '',
                 picUrl: ''
	        }
	    },
	    methods: {
            renderPage: function(num) { //渲染pdf
            	
                  var vm = this
                  this.pageRendering = true;
                  var canvas = document.getElementById('the-canvas')
                  // Using promise to fetch the page
                  this.pdfDoc.getPage(num).then(function(page) {
                        var viewport = page.getViewport(vm.scale);
                        //alert(vm.canvas.height)
                        console.log(canvas)
                        console.log(viewport)
                        canvas.height = viewport.height;
                        canvas.width = viewport.width;

                        // Render PDF page into canvas context
                        var renderContext = {
                              canvasContext: vm.ctx,
                              viewport: viewport
                        };
                        var renderTask = page.render(renderContext);

                        // Wait for rendering to finish
                        renderTask.promise.then(function() {
                              vm.pageRendering = false;
                              if(vm.pageNumPending !== null) {
                                    // New page rendering is pending
                                    vm.renderPage(vm.pageNumPending);
                                    vm.pageNumPending = null;
                              }
                        });
                  });
                  vm.page_num = vm.pageNum;
                  

            },
            addscale: function() {//放大
                  if(this.scale >= this.maxscale) {
                        return
                  }
                  this.scale += 0.1;
                  this.queueRenderPage(this.pageNum)
            },
            minus: function() {//缩小
                  if(this.scale <= this.minscale) {
                        return
                  }
                  this.scale -= 0.1;
                  this.queueRenderPage(this.pageNum)
            },
            prev: function() {//上一页
                  var vm = this
                  if(vm.pageNum <= 1) {
                        return;
                  }
                  vm.pageNum--;
                  vm.queueRenderPage(vm.pageNum);
            },
            next: function() {//下一页
                  var vm = this
                  if(vm.pageNum >= vm.page_count) {
                        return;
                  }
                  vm.pageNum++;
                  vm.queueRenderPage(vm.pageNum);
            },
            closepdf: function() {//关闭PDF
                  this.$emit('closepdf');
            	  
            },
            queueRenderPage: function(num) {
                  if(this.pageRendering) {
                        this.pageNumPending = num;
                  } else {
                        this.renderPage(num);
                  }
            },
            getPDF: function(title, url) {
            	 var vm = this
            	 vm.pageNum = 1
            	 vm.title = title
                 PDFJS.getDocument(url).then(function(pdfDoc_) {  //初始化pdf
                       vm.pdfDoc = pdfDoc_;
                       vm.page_count = vm.pdfDoc.numPages
                       vm.renderPage(vm.pageNum);
                 });
            	 
            },
            showPic: function(title, url) {
                this.title = title;
                this.picUrl = url;
            }
      },
      computed: {
            ctx: function() {
                  var id = document.getElementById('the-canvas')
                  return id.getContext('2d');
            }
      
      },
      mounted: function() {
           
      }
	})
/* 	validator.extend('mobile', {
		getMessage: field =>  field + '必须为11位手机号码',
	    validate: value => {
	      return value.length == 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/.test(value)
	    }
	});  */
    </script>
    <style type="text/css">
    	.form-error {
    		border: 1px #DD5A43 solid !important;
    	}
    	
input.form-error::-webkit-input-placeholder { /* WebKit browsers */  
    color:    #DD5A43!important;  
    font-style: italic;
}  
input.form-error:-moz-placeholder { /* Mozilla Firefox 4 to 18 */  
    color:    #DD5A43!important;  
     font-style: italic;
}  
input.form-error::-moz-placeholder { /* Mozilla Firefox 19+ */  
    color:    #DD5A43!important;  
     font-style: italic;
}  
input.form-error:-ms-input-placeholder { /* Internet Explorer 10+ */  
    color:    #DD5A43!important;
     font-style: italic;   
}  
.v-info {
	text-align: left!important;;
	color: #DD5A43;
	display: block;
}
    </style>
	</head>