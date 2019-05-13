<%@page import="com.citygreen.crud.PlantingBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City Green</title>
<link rel="shortcut icon" type="image/gif/png" href="logot.png"/>
</head>
<body style="background-image: url('citybg1.jpg'); background-size:100%;">
	<h1 style="color:#FDE9B4; padding-left:280px"><i>Volunteer Message</i></h1>
	<table border="1" width="1050" align="left">
		<tr bgcolor="tomato">
			<th><b>Name</b></th>
			<th><b>Mobile Number</b></th>
			<th><b>Address Details</b></th>
			<th><b>No of Participants</b></th>
			<th><b>No of Plants Required</b></th>
			<th><b>Date & Time</b></th>
			<th><b>Notes</b></th>		
		</tr>
		<%List<PlantingBean> planting_details = (List<PlantingBean>)request.getAttribute("volunteer_message");
		for(PlantingBean volunteer_msg : planting_details){%>
			<tr bgcolor="#37CDA8">
				<td><%= volunteer_msg.GetName() %></td>
				<td><%= volunteer_msg.GetContact() %></td>
				<td><%= volunteer_msg.GetArea_details() %></td>
				<td><%= volunteer_msg.GetParticipants() %></td>
				<td><%= volunteer_msg.GetPlants() %></td>
				<td><%= volunteer_msg.GetDate_Time() %></td>
				<td><%= volunteer_msg.GetNotes() %></td>
			</tr>
		<%}%>	
	</table>
</body>
</html>