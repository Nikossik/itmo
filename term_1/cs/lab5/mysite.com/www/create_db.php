<?php
	$link = mysqli_connect ("localhost", "root", "");
	if ($link) {
		echo "Connection done!", "<br>";
	} else {
		echo "No connection";
	}

	$db = "MySiteDB";
	$query = "CREATE DATABASE $db";
	$create_db = mysqli_query($link, $query);
	if ($create_db) {
		echo "DB $db created completly";
	} else {
		echo "DB is not complete";
	}
?>
