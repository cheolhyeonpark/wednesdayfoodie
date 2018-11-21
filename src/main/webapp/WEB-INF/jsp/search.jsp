<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr style="margin-bottom: 10px;">
			<th style="text-align: left; border-bottom: 2px solid gray; font-size: 15px;">리뷰</th>
		</tr>
		<c:forEach var="blog" items="${blogList}">
			<tr>
				<td class="toptd"><a href="${blog.link}" target="_blank">${blog.titl}</a></td>
			</tr>
			<tr>
				<td>${blog.description}</td>
			</tr>
			<tr>
				<td style="padding-bottom: 5px; border-bottom: 1px solid gray;">작성자
					: ${blog.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>