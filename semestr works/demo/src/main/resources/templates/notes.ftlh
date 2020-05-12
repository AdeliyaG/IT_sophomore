<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Notebook</title>
</head>
<body>
<h3>List of ur notes:</h3>
    <#list notes as note>
        <ul>
            <li>${note}</li>
        </ul>
    </#list>
</body>
</html>