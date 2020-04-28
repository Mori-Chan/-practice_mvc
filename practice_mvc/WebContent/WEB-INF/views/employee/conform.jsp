<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee detail</title>
<link rel="stylesheet" href='<c:url value="/css/list.css"/>'>
</head>
<body>

	<h1>新規登録確認画面</h1>
		<f:form modelAttribute="EmployeeModel" action="entry.do" method = "POST">
		<table>

			<tr>
				<td>ID</td>
				<td>
				<input type="hidden" value="${employee.id }" id="id" name="id">${employee.id }
				</td>
			</tr>
			<tr>
				<td>姓</td>
				<td>
				<input type="hidden" value="${employee.family_name }" id="family_name" name="family_name">${employee.family_name }
				</td>
			</tr>
			<tr>
				<td>名</td>
				<td>
				<input type="hidden" value="${employee.first_name }" id="first_name" name="first_name">${employee.first_name }
				</td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<c:choose>
						<c:when test = "${employee.sex == 'f'}">
	  						<input type="hidden" value="${employee.sex }" id="sex" name="sex">女
						</c:when>
						<c:otherwise>
	  						<input type="hidden" value="${employee.sex }" id="sex" name="sex">男
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td>
				<input type="hidden" value="${employee.birthday }" id="birthday" name="birthday">${employee.birthday }
				</td>
			</tr>

	</table>
	<input type="submit" value="OK" >
	</f:form>
	<f:form modelAttribute="EmployeeModel" action="cancel.do" method = "POST">
	<input type="hidden" value="${employee.id }" id="id" name="id">
	<input type="hidden" value="${employee.family_name }" id="family_name" name="family_name">
	<input type="hidden" value="${employee.first_name }" id="first_name" name="first_name">
	<c:choose>
						<c:when test = "${employee.sex == 'f'}">
	  						<input type="hidden" value="${employee.sex }" id="sex" name="sex">
						</c:when>
						<c:otherwise>
	  						<input type="hidden" value="${employee.sex }" id="sex" name="sex">
						</c:otherwise>
					</c:choose>
	<input type="hidden" value="${employee.birthday }" id="birthday" name="birthday">
	<input type="submit" value="キャンセル" ></f:form>
<!--  -->
</body>
</html>