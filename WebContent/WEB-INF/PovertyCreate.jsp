<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Create Poverty record</title>
</head>
<body>
	<h1>Create Poverty record</h1>
	<form action="povertycreate" method="post">
		<p>
			<label for="recordId">RecordID</label>
			<input id="recordId" name="recordId" value="">
		</p>
		<p>
			<label for="year">Year</label>
			<input id="year" name="year" value="">
		</p>
		<p>
			<label for="povertyPopulation">PovertyPopulation</label>
			<input id="povertyPopulation" name="povertyPopulation" value="">
		</p>
		<p>
			<label for="percentPovertyPopulation">PercentPovertyPopulation</label>
			<input id="percentPovertyPopulation" name="percentPovertyPopulation" value="">
		</p>
		<p>
			<label for="confidenceInterval">ConfidenceInterval</label>
			<input id="confidenceInterval" name="confidenceInterval" value="">
		</p>
		<p>
			<label for="ageGroupId">AgeGroupID</label>
			<input id="ageGroupId" name=""ageGroupId"" value="">
		</p>
		<p>
			<label for="countyId">CountyID</label>
			<input id="countyId" name="countyId" value="">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>

</body>
</html>