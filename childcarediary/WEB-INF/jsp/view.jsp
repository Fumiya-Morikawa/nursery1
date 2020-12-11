<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style4.css">
<title>保育日誌</title>
</head>
<body>
    <div class="background-wrapper">
        <div class="view-wrapper">
            <div class="view-container">
                <h1>保育日誌</h1>
                <div class="datename">
                    <div class="date"><span style="border-bottom:solid 1px;">
                        日付：<c:out value="${ viewDiaryInfo.date }" /></span>
                    </div>
                    <div class="name"><span style="border-bottom:solid 1px;">
                        記入者：<c:out value="${ viewDiaryInfo.name }" /></span>
                    </div>
                </div>
                <br><br>
                <div class="aim">
                    <p>ねらい：<c:out value="${ viewDiaryInfo.aim }" /></p>
                </div>
                <br>
                <div class="contents-container">
                    <p>内容</p>
                    <div class="contents">
                        <c:out value="${ viewDiaryInfo.contents }" />
                    </div>
                </div>
                <br><br>
                <div class="submit-container">
                    <form action="${ pageContext.request.contextPath }/DeleteServlet" method="post">
                        <input type="hidden" name="id" value="${ viewDiaryInfo.id }" />
                        <input type="submit" value="削除" />
                    </form>
                    <form action="${ pageContext.request.contextPath }/UpdateServlet1" method="post">
                        <input type="hidden" name="id" value="${ viewDiaryInfo.id }" />
                        <input type="hidden" name="date" value="${ viewDiaryInfo.date }" />
                        <input type="hidden" name="name" value="${ viewDiaryInfo.name }" />
                        <input type="hidden" name="aim" value="${ viewDiaryInfo.aim }" />
                        <input type="hidden" name="contents" value="${ viewDiaryInfo.contents }" />
                        <input type="submit" value="編集">
                    </form>
                    <br><br>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <div class="forward-container">
        <a href="./FindAllServlet" class="list">日誌一覧へ</a> &nbsp;&nbsp;
        <a href="${ pageContext.request.contextPath }/toppage.jsp" class="toppage">トップページへ  </a>
    </div>   
</body>
</html>