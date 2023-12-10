<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notes</title>
</head>
<body>
    <h1>Notes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Created</th>
            <th>Title</th>
			<th>Article</th>

        </tr>
        <?php

        require_once ("MySiteDB.php"); 
		mysqli_select_db($link, $db);

		$query_select_notes = "SELECT * FROM notes";
		$result_select_notes = mysqli_query($link, $query_select_notes);

		while ($note = mysqli_fetch_array($result_select_notes)){
			echo '<tr>';
			echo '<td>' . 'ID:' . $note ['id'], "<br>";
			echo '<td>' . 'Created:' . $note ['created'], "<br>";
			echo '<td>' . 'Title:' . $note ['title'], "<br>";
			echo '<td>' . 'Article:' . $note ['article'], "<br>";
			echo '</tr>';
		}

        mysqli_close($link);
        ?>
    </table>
</body>
</html>