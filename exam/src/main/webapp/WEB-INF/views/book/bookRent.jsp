<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	<h1>도서목록 조회</h1>
	<table class="table">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${booRent}" var="book">
				<tr onclick="location.href='bookInfo?book_no=${book.bookNo}'">
					<td>${book.bookNo }</td>
					<td>${book.bookName }</td>
<%-- 					<th>${book.bookCoverImg}</th> --%>
					<td><img style="width:200px" src="<c:url value="/resources/images/${book.bookCoverImg }"/>"></td>
					<td>
						<fmt:formatDate value="${book.bookDate}"
								pattern="yyyy년MM월dd일"/>
					</td>
					<td>${book.bookPrice }</td>
					<td>${book.bookPublisher }</td>
					<td>${book.bookInfo }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
