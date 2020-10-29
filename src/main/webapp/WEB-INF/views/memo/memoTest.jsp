<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

		<c:forEach items="${list}" var="dto" varStatus="i">
			<tr>
				<td id="num${dto.num}">${dto.num}</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.regDate}</td>
				<td><button class="btn-xs btn-danger del" id="${dto.num}">DEL</button></td>
			</tr>
		</c:forEach>	
