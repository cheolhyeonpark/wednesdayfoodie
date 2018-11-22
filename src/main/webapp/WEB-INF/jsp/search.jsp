<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 13px;
	color: rgba(0, 0, 0, .7);
}

a {
	text-decoration: none;
	color: rgba(0, 0, 0, .7);
}

a:hover {
	text-decoration: underline;
	color: rgba(0, 0, 0, .9);
}
</style>
</head>
<body>
	<table>
		<tr style="margin-bottom: 10px;">
			<th
				style="padding-bottom: 5px; text-align: left; border-bottom: 2px solid gray; font-size: 25px;">블로그 리뷰</th>
		</tr>
		<c:forEach var="blog" items="${blogList}">
			<tr>
				<td style="font-size: 14px;"><a href="${blog.link}" target="_blank">${blog.titl}</a></td>
			</tr>
			<tr>
				<td>${blog.description}</td>
			</tr>
			<tr>
				<td style="padding-bottom: 5px; border-bottom: 1px solid gray; text-align: right;">${blog.name}</td>
			</tr>
		</c:forEach>
		<tr>
			<td style="padding-top: 10px; text-align: center;">
			<c:if test="${start != 1}"><a href="http://13.125.145.195:8080/wednesdayfoodie/app/search?query=${titl }&page=${start-1 }">이전</a> </c:if>｜ 
			<c:forEach var="i" begin="${start }" end="${end }" step="1"> 
				<a href="http://13.125.145.195:8080/wednesdayfoodie/app/search?query=${titl }&page=${i }">${i }</a> ｜
			</c:forEach>
<%--  			<c:if test="${total != end }"><a href="http://13.125.145.195:8080/wednesdayfoodie/app/search?query=${titl }&page=${end+1 }">다음</a></c:if> --%>
<!-- 네이버 엔진에서 검색을 10page 까지 제한함. -->
			</td>
		</tr>
	</table>
</body>
</html>