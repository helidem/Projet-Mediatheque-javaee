<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mediatek2022</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>

</head>

<body>
<div id="bg">
    <br>
    <b><u>
        <h1>AJOUTER UN DOCUMENT</h1>
    </u></b>
    <div id="form">
        <form method="POST" action="../addDocument">
            <table id="table">
                <tr>
                    <td>TYPE :</td>
                    <td>
                        <input type="radio" name="type" id="livre" value="livre">
                        <label>Livre</label>
                        <input type="radio" name="type" id="cd" value="cd">
                        <label>CD</label>
                    </td>
                </tr>
                <tr>
                    <td>TITRE :</td>
                    <td>
                        <input type="text" name="titre" id="titre" size="30" maxlength="30"
                               placeholder="Entrez le titre du document"/>
                        (max 30 caractères)
                    </td>
                </tr>
                <tr>
                    <td>AUTEUR :
                    </td>
                    <td><input type="text" name="auteur" id="auteur" size="30" maxlength="30"
                               placeholder="Entrez le nom de l'auteur"/>
                        (max 30 caractères A-Z et a-z)
                    </td>
                </tr>
                <tr>
                    <td>DESCRIPTION :</td>
                    <td><textarea name="description" id="description" rows="4" cols="40" id="comments">
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
            <p class="document-registration-error">
                <%=  request.getSession().getAttribute("messageAjoutDocument") == null ? "" : request.getSession().getAttribute("messageAjoutDocument") %>
            </p>
        </form>
    </div>
</div>
<div class="power-off-div">
    <a href="../">
        <img class="power-off-icon" src="../assets/power-icon.png" width="40" height="40"/>
    </a>
</div>
</body>

</html>

<style>
    @import url("https://fonts.googleapis.com/css2?family=Poppins&display=swap");

    .power-off-icon {
        position: absolute;
        top: 20px;
        right: 20px;
    }

    #bg {
        background-color: blue;
        border: 2px solid whitesmoke;
        padding: 40px;
        position: absolute;
        margin-left: 340px;
        margin-top: 10px;
        height: 550px;
        width: 780px;
        line-height: 0px;
    }

    h1 {
        color: skyblue;
        text-align: center;
        padding: 0px;
        font-size: 30px;
    }

    #form {
        background-color: skyblue;
        border: 2px solid black;
        padding: 40px;
        position: absolute;
        margin-left: auto;
        margin-right: auto;
        margin-top: 20px;
        height: 400px;
        width: 700px;
        line-height: 0px;
    }

    #table {
        height: 400px;
        width: 700px;
        text-align: justify;
        color: white;
        font-weight: bold;
        font-style: normal;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    th {
        text-align: center;
    }

    td {
        padding: 2px;
        justify-content: left;
    }

    tr {
        padding: 30px;
        width: 200px;
        border-collapse: separate;

        text-align: left;
    }

    #submit_p1 {
        text-align: center;
        font-weight: bolder;
        font-size: xx-large;
        color: lawngreen;
    }

    #submit_p2 {
        text-align: center;
        font-size: xx-large;
        font-weight: bold;
        color: purple;
    }

    a {
        text-align: center;
        font-size: xx-large;
        font-weight: bold;
        color: slateblue;
    }

    input,
    select {
        color: #5a5854;
        background-color: #f2f2f2;
        padding: 4px 4px 4px 2px;
        border-radius: 10px;

        margin-bottom: 1px;
    }

    input:focus {
        background-color: #ffffff;
        border: 2px solid #b1e1e4;
        border-spacing: 2px 2px;
    }

    .document-registration-error {
        color: red;
        font-family: "Poppins", sans-serif;
    }
</style>