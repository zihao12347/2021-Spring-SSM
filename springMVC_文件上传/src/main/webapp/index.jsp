<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>传统方式的文件上传!</h2>
<br>
<form action="file/uploadOne" enctype="multipart/form-data" method="post">
    请选择需要上传的文件<input type="file" name="file"><br>
    <input type="submit">
</form>
<br/>
<h2>SpringMVC方式的文件上传!</h2>
<br>
<form action="file/mvcupload" enctype="multipart/form-data" method="post">
    请选择需要上传的文件<input type="file" name="file"><br>
    <input type="submit">
</form>
<h2>跨服务器方式的文件上传!</h2>
<br>
<form action="file/acrossServerFileupload" enctype="multipart/form-data" method="post">
    请选择需要上传的文件<input type="file" name="file"><br>
    <input type="submit">
</form>
</body>
</html>
