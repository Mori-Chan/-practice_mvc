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

	<h1>従業員詳細画面</h1>

	<f:form modelAttribute="EmployeeModel" action="update.do" method = "POST">

		<c:choose>
		<c:when test="${employee.msg != null }">
		<table>

			<tr>
				<td>ID</td>
				<td>
				<input type="hidden" value="${employee.id }" id="id" name="id">
				${employee.id }
				</td>
			</tr>
			<tr>
				<td>姓</td>
				<td><input type="text" value="${employee.family_name }" id="family_name" name="family_name"></td>
			</tr>

			<tr>
				<td>名</td>
				<td><input type="text" value="${employee.first_name }" id="first_name" name="first_name"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
				<c:choose>
						<c:when test = "${employee.sex == 'f'}">
						<input type="radio" id="sex" name="sex" value="m" /> 男
						<input type="radio" id="sex" name="sex" value="f" checked="checked" /> 女
						</c:when>
						<c:otherwise>
						<input type="radio" id="sex" name="sex" value="m" checked="checked" /> 男
						<input type="radio" id="sex" name="sex" value="f" /> 女
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td>
				<input type="date" value="${employee.birthday }" id="birthday" name="birthday">
				</td>
			</tr>

		</table>
		<p class = "eror">${employee.msg }</p>
		</c:when>
		<c:otherwise>

		<table>

			<tr>
				<td>ID</td>
				<td>
				<input type="hidden" value="${employee.id }" id="id" name="id">
				${employee.id }
				</td>
			</tr>

			<tr>
				<td>姓</td>
				<td><input type="text" value="${employee.family_name }" id="family_name" name="family_name"></td>
			</tr>

			<tr>
				<td>名</td>
				<td><input type="text" value="${employee.first_name }" id="first_name" name="first_name"></td>
			</tr>

			<tr>
				<td>性別</td>
				<td>
					<c:choose>
						<c:when test = "${employee.sex == 'f'}">
						<input type="radio" id="sex" name="sex" value="m" /> 男
						<input type="radio" id="sex" name="sex" value="f" checked="checked" /> 女
						</c:when>
						<c:otherwise>
						<input type="radio" id="sex" name="sex" value="m" checked="checked" /> 男
						<input type="radio" id="sex" name="sex" value="f" /> 女
						</c:otherwise>
					</c:choose>
				</td>
			</tr>

			<tr>
				<td>生年月日</td>
				<td>
				<input type="date" value="${employee.birthday }" id="birthday" name="birthday">
				</td>
			</tr>

		</table>
		</c:otherwise>
		</c:choose>
		<input type="submit" value="更新">
	</f:form>
	<f:form modelAttribute="EmployeeModel" action="delete.do" method = "POST">
		<input type="hidden" value="${employee.id }" id="id" name="id">
		<input type="submit" value="削除">
	</f:form>
	<form action="first.do">
		<input type="submit" value="戻る">
	</form>

<!--  -->
</body>
</html>