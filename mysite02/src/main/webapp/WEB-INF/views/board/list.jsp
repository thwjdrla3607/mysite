<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:set var="count" value="${fn.length(list)}" />
					<c:forEach var="vo" items="${list }" varStatus="list">
						<tr>
							<td>${list.count}</td>
							<td style="padding-left: ${((vo.depth + 1) - 1)*30 }px">
								<c:if test='${vo.depth > 1 }'>
									<img src="${pageContext.request.contextPath }/assets/images/reply.png">
								</c:if>
								<a href="${pageContext.request.contextPath }/board?a=viewform&no=${vo.no}">${vo.title}</a></td>
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<c:if test="${authUser.no == vo.userNo}">
								<td><a
									src="${pageContext.request.contextPath }/assets/images/recycle.png"
									href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no}"
									class="del">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>


				</table>
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<c:if test="${pageInfo.hasPrev == true}">
							<li><a href="${pageContext.request.contextPath }/board?pageNo=${pageInfo.curNo - 1}">◀</a></li>
						</c:if>
						<c:forEach var="no" begin="${pageInfo.begin }" end="${pageInfo.end }">
							<c:choose>				
								<c:when test="${pageInfo.curNo != no}">
									<li><a href="${pageContext.request.contextPath }/board?pageNo=${no }">${no }</a></li>
								</c:when>
								<c:when test="${pageInfo.curNo == no}">
									<li class="selected">${no }</li>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${pageInfo.hasNext == true}">
							<li><a href="${pageContext.request.contextPath }/board?pageNo=${pageInfo.curNo + 1}">▶</a></li>
						</c:if>
					</ul>
				</div>
				<!-- pager 추가 -->
				<c:if test="${not empty authUser}">
					<div class="bottom">
						<a href="${pageContext.request.contextPath }/board?a=writeform"
							id="new-book">글쓰기</a>
					</div>
				</c:if>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>