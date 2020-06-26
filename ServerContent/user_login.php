<?php

	$userid = ($_GET['userid']) ? $_GET['userid'] : $_POST['userid'];
	$passwd = ($_GET['passwd']) ? $_GET['passwd'] : $_POST['passwd'];
	if($userid == '' || $passwd == ''){
		echo 'error data';
	}else{
		$db_table = 'MS_USER';

		require_once('dbConnect.php');
		$sql = "SELECT * FROM $db_table WHERE userid='$userid' and passwd = password('$passwd')";

		$result = mysqli_query($con,$sql);
	 	$total_record = mysqli_num_rows($result);
		if($total_record <=0)
		{
				echo '[{"result":"no user"}]';
		} else {
			
				echo '[{"result":"login success"}]';
		}
	 mysqli_close($con);
	}
?>