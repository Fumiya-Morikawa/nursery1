<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>トップページ</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css">
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
        <div class="top-wrapper">
            <div class="top-container">
                <h1>保育日誌</h1>
            </div>
        </div>
        <div class="command-wrapper">
            <div class="command-container">
                <a href="./FindAllServlet" class="list">日誌の閲覧</a>
                <a href="./ToppageForward" class="regist">日誌の新規作成</a>
            </div>
        </div>
    </div>
    
    <div class="footer">
        <div class="footer-container">
        Child care diary management system.
        </div>
    </div>
</body>
</html>