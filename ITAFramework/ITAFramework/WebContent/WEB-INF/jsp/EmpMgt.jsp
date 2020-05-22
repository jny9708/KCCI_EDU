<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${title}</title>
</head>
<body>
<table width="100%" height="700">
	<tr height="100">
		<td>
			<table width="100%">
				<tr>
					<td width="120"><img src="images/logo.jpg"></td>
					<td align="left" style="font-size:28pt; font-style:bold;background:blue; color:yellow"> ITA 직원 관리 시스템</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr height="550">
		<td valign="top">
			<jsp:include page="${contents}" />
		</td>
	</tr>
	<tr height="50">
		<td><img src="images/bottom.gif"></td>
	</tr>
</table>
</body>
</html>