<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>

<form:form method="post" modelAttribute="citiReqRes" action="${pageContext.request.contextPath}/addCitiApiReqRes">
<table>
		<tr>
			<th colspan="2">Select City API</th>
		</tr>
		<tr>
	<form:hidden path="id" />
          <td><form:label path="apiName">Select Api</form:label></td>
          <td>
          	<form:select path="apiName" class="form-control">
          		<form:option value="cityRewardBalance">City RewardBalance</form:option>
          		<form:option value="cityEligibility">City Eligibility</form:option>
          		<form:option value="cityEnablement">City Enablement</form:option>
          		<form:option value="cityRedemption">City Redemption</form:option>
          	</form:select>
          </td>
        </tr>
		<tr>
			<td colspan="2"><input type="submit" class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>City Request Response List</h3>
<c:if test="${!empty listOfReqRes}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Request Url</th>
		<th width="120">Response Data</th>
		<th width="60">Api Name</th>
		<th width="60">Creation Time</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfReqRes}" var="citiReqRes">
		<tr>
			<td>${citiReqRes.id}</td>
			<td>${citiReqRes.requestUrl}</td>
			<td>${citiReqRes.responseData}</td>
			<td>${citiReqRes.apiName}</td>
			<td>${citiReqRes.creationTime}</td>
			<td><a href="<c:url value='/deleteCitiApiReqRes/${citiReqRes.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>