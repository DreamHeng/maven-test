<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
                    <script>
                        $("#numcode").blur(checkCode = function () {
                            isOk = true;
                            var code = $("#numcode").val();
                            $.ajax({
                                url:"${pageContext.request.contextPath}/admin/yanzheng?",
                                data: {"code": code},
                                dataType: "json",
                                async: false,
                                success: function (data) {
                                    if (data) {
                                        $("#code1").val("验证码正确");
                                    } else {
                                        $("#code1").val("验证码错误");
                                        isOk = false;
                                    }
                                }
                            });
                            return isOk;
                        });

                        $("#form").submit(function () {
                            return checkCode();
                        })
                    </script>
                    <%----%>
					<form id="form" action="${pageContext.request.contextPath}/admin/regist" method="post">

						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username"/>
                                    <span id="check" style="color: red"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="${pageContext.request.contextPath}/admin/getImage" />
									<a href="javascript:void(0);" onclick="document.getElementById('num').src = '${pageContext.request.contextPath}/admin/getImage?a='+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" id="numcode" />
                                    <span id="code1" style="color: red"></span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
