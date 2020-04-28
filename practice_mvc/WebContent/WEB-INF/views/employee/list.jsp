<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee list</title>
<link rel="stylesheet" href='<c:url value="/css/list.css"/>'>
</head>
<body>

	<h1>従業員一覧画面</h1>

	<form action="move.do" method = "GET">
	<input type="submit" value="新規登録画面">
	</form>

	<f:form modelAttribute="EmployeeModel" action="sort.do" method = "GET">
    <f:select path="sort" items="${checkSort}" />
    <f:select path="cend" items="${checkCend}" />
    	<input type="submit" value="ソートする"/>
	</f:form>

		<table>

			<tr>
			<th>ID</th>
			<th>姓</th>
			<th>名</th>
			<th>性別</th>
			<th>生年月日</th>
			<th>詳細へ</th>
			</tr>
		<c:forEach items="${employees}" var="employee" varStatus="status">

			<tr>
				<td>${employee.id }</td>
				<td>${employee.family_name }</td>
				<td>${employee.first_name }</td>
			<c:choose>
			<c:when test = "${employee.sex == 'f'}">
  						<td>女</td>
			</c:when>
			<c:otherwise>
  						<td>男</td>
			</c:otherwise>
			</c:choose>
				<td>${employee.birthday }</td>
				<td>
				<f:form modelAttribute="EmployeeModel" action="detail.do" method = "GET">
				<input type="hidden" value="${employee.id }" id="id" name="id">
				<input type="submit" value="詳細">
				</f:form>
				</td>
			</tr>

			</c:forEach>

		</table>
<!--  -->
</body>
</html>