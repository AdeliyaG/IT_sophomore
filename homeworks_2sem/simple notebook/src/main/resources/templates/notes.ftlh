<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/skeleton.css">
    <title>Notebook</title>
</head>
<body>

<div class="container" style="justify-content: center">
    <div class="row">
        <h4 style="margin: 15px; text-align: center">Search:</h4>
        <form method="post" action="/notebook"
              style="justify-content: center; align-content: center; display: flex;margin-bottom: 0px">
            <input type="text" name="substring" style="margin-right: 5px;">
            <button class="button-primary" type="submit" name="search">search</button>
        </form>

        <table class="u-full-width">
            <thead>
            <tr>
                <th>Name</th>
                <th>Number</th>
            </tr>
            </thead>
            <tbody>
            <#list notes as note>
            <tr>
                <td>${note.name}</td>
                <td>${note.number}</td>
            </tr>
            </#list>
            </tbody>
        </table>

        <div class="row">
            <#if pageCount != 0>
                <#list 1..pageCount as x>
                <a class="button" href="/notebook/${x}"
                   style="text-align: right; color: #33C3F0; font-size: 15px; padding: 0 12px">${x}</a>
                </#list>
            </#if>

            <a class="button" href="/addNote"
               style="text-align:justify; font-size: 15px; padding: 0 12px">back</a>
        </div>
    </div>
</div>

</body>
</html>