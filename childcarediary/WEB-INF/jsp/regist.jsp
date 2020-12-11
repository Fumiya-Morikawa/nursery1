<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日誌の新規登録</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style3.css">
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
                <h1>日誌の新規作成</h1><br>
                <div class="message">
                    ${ message }
                </div>
            </div>
        </div>
        <div class="main-wrapper">
            <div class="main-container">
                <div class="regist-container">
                    <form action="${ pageContext.request.contextPath }/RegistServlet" method="post">
                        <div class="text"> 
                            <div class="date">
                                日付：<input type="text" name="date" size=15 style="font-size:24px;" />
                            </div>
                            <div class="name">
                                記入者：<input type="text" name="name" size=15 style="font-size:24px;" />
                            </div>
                        </div>
                        <br>
                        <div class="aim">
                            <p>ねらい：<br>
                                <textarea name="aim" style="font-size:16px;"></textarea>
                            </p>
                        </div>
                        <br>
                        <div class="contents">
                            <p>内容：<br>
                                <textarea name="contents" style="font-size:16px;"></textarea>
                            </p>
                        </div>
                        <br>
                        <div class="submit">
                            <p>
                                <input type="submit" value="新規投稿">
                            </p>
                        </div>
                </form>
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