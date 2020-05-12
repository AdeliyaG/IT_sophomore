<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/skeleton.css">
    <title>Note adding</title>
</head>
<body>

<div class="container" style="margin-top: 150px">
    <div class="row">
        <h4 style="margin: 15px; text-align: center">Add your note:</h4>
        <form method="post" action="/addNote" style="justify-content: center; align-content: center; display: flex;margin-bottom: 0px">
            <input type="text" name="name" placeholder="Name" style="margin-right: 5px;">
            <input type="text" name="number" placeholder="Number" style="margin-right: 5px;">
            <button class="button-primary" type="submit" name="saveButton">save</button>
        </form>
        <div class="row" style="text-align: center">
            <a class="button" href="/notebook/1" style="text-align: center; color: #33C3F0; border: none">notebook</a>
        </div>
    </div>

</div>
</body>
</html>