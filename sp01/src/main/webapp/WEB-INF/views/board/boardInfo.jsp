<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h1>게시글 조회</h1>
	<table>
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea>${boardInfo.content}</textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><img style="width:200px" src="<c:url value="/resources/${boardInfo.image }"/>"></td>
		</tr>
		<tr>
			<th>작성날짜</th>
			<td>${boardInfo.regdate}</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardList'">목록으로</button>
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
</div>