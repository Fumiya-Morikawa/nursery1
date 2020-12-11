<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日誌の閲覧</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style2.css">
</head>
<body>
    <div class="header">
        <div class="header-container">
            <p>
            <span style="color:red">Child</span>
            <span style="color:yellow"> care</span>
            <span style="color:#55acee"> diary</span>
            <span style="color:green"> management</span>
            <span style="color:white"> system</span>
            </p>
        </div>
    </div>

    <div class="background-wrapper">
        <div class="list-wrapper">
            <div class="list-container">
                <h1>日誌一覧</h1><br>
                <div class="main-container">
                    <c:forEach var="diaryInfo" items="${ diaryInfoList }">
                    <form name="diary_form" action="./ViewServlet" method="post">
                        <input type="hidden" name="id" value="${ diaryInfo.id }" />
                        <input type="hidden" name="date" value="${ diaryInfo.date }" />
                        <input type="hidden" name="name" value="${ diaryInfo.name }" />
                        <input type="hidden" name="aim" value="${ diaryInfo.aim }" />
                        <input type="hidden" name="contents" value="${ diaryInfo.contents }" />
                        <c:out value="${ diaryInfo.date }"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
                        <c:out value="${ diaryInfo.aim }"></c:out>
                        <input type="submit" value="閲覧" class="submit" />
                    </form>
                    </c:forEach>
                </div>
            </div>
        </div>
        <br><br>
        <a href="${ pageContext.request.contextPath }/toppage.jsp" class="toppage">トップページへ</a>
    </div>

    <div class="footer">
        <div class="footer-container">
        Child care diary management system.
        </div>
    </div>
</body>
</html>