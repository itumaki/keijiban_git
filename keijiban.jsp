<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%
List<String> message = (List<String>)session.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>孤独の掲示板</title>
</head>
<body>
<h1>孤独の掲示板</h1>


	<!-- 送信ボタン詳細 -->
<form action="/s1832067/Keijiban" method="POST">

		<input type="text" name="chat" size="60" value="">

		<input type="submit" name="action" value="送信">
</form>
<hr>
	<% if (message != null) { %>

<table>
		<!-- 送信を押すと、上から過去の内容を積み上げていく-->
	<% for (int i = 0; i < message.size(); i++) { %>
<tr>
	<td><%=	message.get(i) %></td>
</tr>

<% } %>

</table>


<% } %>


</body>

</html>