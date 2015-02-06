<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import= "es.open4job.aytozgz.opendata.modelo.dao.*"%>
<%@ page import= "es.open4job.web.form.*"%>
<%@ page import= "java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<logic:iterate name="lstMotos" id="lstMotosId">
<p>
	Lista Motos <bean:write name="lstMotosId" property="id"/> , 
	<bean:write name="lstMotosId" property="title"/> 
</p>
</logic:iterate>
</body>
</html>