<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆中国矿业大学选课系统</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="css/ionicons.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
function login(formName){
	console.log(formName);
	elementsValue=new Array();
	var form=document.getElementById(formName);
	var tagElements=form.getElementsByTagName('input');
	for(var j=0;j<tagElements.length;j++){
		switch(tagElements[j].type.toLowerCase()){
		case 'text':
			elementsValue.push(tagElements[j].value);
		break;
		case 'password':
			elementsValue.push(tagElements[j].value);
		break;
		}
	};
		$.ajax({  
	        type: "POST",  
	        url: "http://localhost:8090/SRSDemo/loginForm",  
	        //contentType: "application/json", //必须有  
	        //dataType: "text", //表示返回值类型，不必须
	        traditional:true,
	        data:{ssn:elementsValue[0],password:elementsValue[1]}, 
	        success: function () {  
	        	}
})
	}
</script>
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<style>
.container{
width:100%;
height:100%;
 background-color: #4F94CD;
}
.center{
overflow:auto;
margin: auto;
position: absolute;
top: 0; left: 0; bottom: 0; right: 0;
}
.col-sm-2 control-label{
text-align:left;
}
</style>
</head>

<body>
<div id="container" class="container">
<div style="width:25%;height:50%;" class="center">
          <!-- Horizontal Form -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">欢迎登陆电子商务选课系统</h3>
            </div>
 <form class="form-horizontal" id="form-horizontal" action="loginForm" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left" >用户名</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" placeholder="Username" name="ssn">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label"style="text-align:left">密码</label>

                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox">记住密码
                      </label>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div >
                    <div class="RadioButtonList">
	                    <input id="RadioButtonList1_1" type="radio" name="radio" value="professor" tabindex="4">
						<label for="RadioButtonList1_1">教师</label>
	                     <input id="RadioButtonList1_2" type="radio" name="radio" value="student" checked="checked" tabindex="4">
						<label for="RadioButtonList1_2">学生</label>
                    </div>
                  </div>
                </div>
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
               <!--  <button type="submit" class="btn btn-default">取消</button> -->
                <button type="submit" class="btn btn-info pull-right" >登陆</button>
              </div>
              <!-- /.box-footer -->
            </form>
     </div>
 </div>
 </div>
</body>
</html>