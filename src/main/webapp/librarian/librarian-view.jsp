<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mediatek2022</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
          integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>

    <link href="librarian-view.css" rel="stylesheet"/>

</head>

<body>
<div id="bg">
    <br>
    <b><u>
        <h1>AJOUTER UN DOCUMENT</h1>
    </u></b>
    <div id="form">
        <form method="get" action="submit.html">
            <table id="table">
                <tr>
                    <td>TYPE :</td>
                    <td><input type="radio" name="type" value="f">
                        <label>Livre</label>
                        <input type="radio" name="type" value="m">
                        <label>CD</label>
                    </td>
                </tr>
                <tr>
                    <td>TITRE :</td>
                    <td>
                        <input type="text" name="titre" size="30" maxlength="30"
                               placeholder="Entrez le titre du document"/>
                        (max 30 caractères)
                    </td>
                </tr>
                <tr>
                    <td>AUTEUR :
                    </td>
                    <td><input type="text" name="auteur" size="30" maxlength="30"
                               placeholder="Entrez le nom de l'auteur"/>
                        (max 30 caractères A-Z et a-z)
                    </td>
                </tr>
                <tr>
                    <td>DESCRIPTION :</td>
                    <td><textarea rows="4" cols="40" id="comments">
                        </textarea>
                    </td>
                </tr>
                <tr>
                <tr>
                    <td>
                        <button type="submit">Submit</button>
                        <button type="reset">Reset</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div class="power-off-div">
    <a href="http://google.com"><img class="power-off-icon" src="power-icon.png" width="40" height="40"/></a>
</div>
</body>

</html>