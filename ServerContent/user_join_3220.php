<?php
	
  	$userid = ($_GET['userid']) ? $_GET['userid'] : $_POST['userid'];
	$passwd = ($_GET['passwd']) ? $_GET['passwd'] : $_POST['passwd'];
	$nickname = ($_GET['nickname']) ? $_GET['nickname'] : $_POST['nickname'];
	if($userid == '' || $passwd == '')
	{
		echo 'error data';
	}
	else
	{
		$db_table = 'MS_USER';

		require_once('dbConnect.php');
		
		$sql = "INSERT INTO $db_table (userid, passwd, nickname) VALUES('$userid', password('$passwd'), '$nickname');";

		if($result = mysqli_query($con,$sql))
		{
			echo '[{"result":"insert success"}]';
		} else {
			echo mysqli_error($con);
		}
	 	mysqli_close($con);
	}
?>