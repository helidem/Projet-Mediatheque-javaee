<%@ page import="mediatek2022.Document" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Mediatek2022</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
          integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V" crossorigin="anonymous"/>
</head>

<body>

<header>
    <nav class="navbar">
        <span class="title">Mediatek2022</span>
    </nav>
</header>

<div class="form-separator"></div>
<div class="row">
    <form method="POST" action="../borrowDocument">
        <div class="main-container column">
            <p>Emprunter un document</p>
            <div class="column">
                <ul id="listFrom1" class="nav nav-pills nav-stacked">
                    <% List<Document> documentsAEmprunter = mediatek2022.Mediatheque.getInstance().tousLesDocumentsDisponibles();
                        for (Document document : documentsAEmprunter) { %>
                    <li data-id="1" class="list-item"><a href="#"><%= document.toString() %>
                    </a></li>
                    <% } %>
                </ul>
                <p>Numéro du document à emprunter :</p>
                <input type="text" name="documentAEmprunter" id="documentAEmprunter">
            </div>
            <br/>
            <div class="row">
                <div class="column">
                    <input type="text" id="hidden1" class="form-control" readonly/>
                    <input type="submit" id="submit1" value="Emprunter" class="btn btn-success"/>
                    <p>
                        <%=  request.getSession().getAttribute("messageEmprunt") == null ? "" : request.getSession().getAttribute("messageEmprunt") %>
                    </p>
                </div>
            </div>
        </div>
    </form>

    <form method="POST" action="../returnDocument">
        <div class="main-container column">
            <p>Rendre un document</p>
            <div class="column">
                <ul id="listFrom2" class="nav nav-pills nav-stacked">
                    <!-- Changer tousLesDocumentsDisponibles() en tousLesDocumentsARetourner(utilisateur) -->
                    <% List<Document> documentsARetourner = mediatek2022.Mediatheque.getInstance().tousLesDocumentsDisponibles();
                        for (Document document : documentsARetourner) { %>
                    <li data-id="1" class="list-item"><a href="#"><%= document.toString() %>
                    </a></li>
                    <% } %>
                </ul>
                <p>Numéro du document à retourner :</p>
                <input type="text" name="documentARetourner" id="documentARetourner">
            </div>
            <br/>
            <div class="column">
                <input type="text" id="hidden2" class="form-control" readonly/>
                <input type="submit" id="submit2" value="Rendre" class="btn btn-success"/>
                <p>
                    <%=  request.getSession().getAttribute("messageRetour") == null ? "" : request.getSession().getAttribute("messageRetour") %>
                </p>
            </div>
        </div>
    </form>

</div>
<a href="../">
    <img class="power-off-icon" src="../assets/power-icon.png" width="40" height="40"/></a>


</body>

</html>

<style>
    @import url("https://fonts.googleapis.com/css2?family=Fredoka&family=Press+Start+2P&display=swap");
    @import url("https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;1,500&display=swap");
    @import url('https://fonts.googleapis.com/css2?family=League+Gothic&family=Mukta:wght@200&display=swap');

    .navbar {
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 200px;
        background: linear-gradient(blue, skyblue);
    }

    .title {
        color: white;
        font-size: 50px;
        font-weight: bold;
        font-family: "Playfair Display", serif;
    }

    .main-container {
        margin: 10px;
        display: flex;
        justify-content: center;
    }

    .row {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
    }

    .column {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }

    ul {
        list-style-type: none;
    }

    .form-control {
        display: none;
    }

    .list-item {
        height: 30px;
        text-align: center;
        color: white;
        font-family: 'Mukta', sans-serif;
        margin: 1px;
        background-color: rgb(72, 57, 206);
    }

    p {
        font-weight: bold;
        font-family: 'Mukta', sans-serif;
    }

    a {
        text-decoration: none;
    }

    a:link {
        color: white;
    }

    a:visited {
        color: white;
    }

    #listFrom1 {
        padding: 0%;
        display: flex;
        flex-direction: column;
        color: white;
        height: 200px;
        width: 200px;
        overflow-y: auto;
        border: 1px solid grey;
    }

    #listTo1 {
        padding: 0%;
        display: flex;
        flex-direction: column;
        color: white;
        height: 200px;
        width: 200px;
        overflow-y: auto;
        border: 1px solid grey;
    }

    #listFrom2 {
        padding: 0%;
        display: flex;
        flex-direction: column;
        color: white;
        height: 200px;
        width: 200px;
        overflow-y: auto;
        border: 1px solid grey;
    }

    #listTo2 {
        padding: 0%;
        display: flex;
        flex-direction: column;
        color: white;
        height: 200px;
        width: 200px;
        overflow-y: auto;
        border: 1px solid grey;
    }

    .power-off-icon {
        position: absolute;
        top: 20px;
        right: 20px;
    }

    body {
        min-height: 100vh;
        margin: 0;
        padding: 0;
    }

    .form-separator {
        border-left: 2px solid black;
        height: 550px;
        position: absolute;
        top: 200px;
        left: 50%;
    }
</style>