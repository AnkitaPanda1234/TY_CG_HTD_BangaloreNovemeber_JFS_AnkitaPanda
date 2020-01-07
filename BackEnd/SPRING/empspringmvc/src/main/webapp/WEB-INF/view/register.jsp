
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="./register" method="post">
		<fieldset>
			<legend>Employee Details</legend>
			<table>
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="text" name="email" required></td>
				</tr>

				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
			</table>
		</fieldset>


		<fieldset>
			<legend>Employee Permanent address</legend>
			<table>
				<tr>
					<td>AddressType</td>
					<td><select name="addressBeans[0].addType">
							<option>--Select Address--</option>
							<option value="P">Permanent</option>
							<option value="T">Temporary</option>
					</select></td>

				</tr>
				<tr>
					<td>Address 1 :</td>

					<td><input type="text" name="addressBeans[0].address1" required></td>
				</tr>
				<tr>
					<td>Address 2 :</td>

					<td><input type="text" name="addressBeans[0].address2" required></td>
				</tr>
			</table>
		</fieldset>


		<fieldset>
			<legend>Employee Temporary address</legend>
			<table>
				<tr>
					<td>Address</td>
					<td><select name="addressBeans[1].addType">
							<option>--Select Address--</option>
							<option value="T">Temporary</option>
							<option value="P">Permanent</option>
					</select></td>
				</tr>
				<tr>
					<td>Address1</td>

					<td><input type="text" name="addressBeans[1].address1" required></td>
				</tr>
				<tr>
					<td>Address2</td>

					<td><input type="text" name="addressBeans[1].address2" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="register" value="register"></td>
				</tr>
			</table>
		</fieldset>

	</form>

</body>
</html>