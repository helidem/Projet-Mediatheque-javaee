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

    <link href="subscriber-view.css" rel="stylesheet"/>
    <script src="subscriber-view.js"></script>

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
            <div class="row">
                <div class="column">
                    <ul id="listFrom1" class="nav nav-pills nav-stacked">
                        <!-- <% for(int i = 0; i < nbDocuments; i++) {}%> -->
                        <li data-id="1" class="list-item"><a href="#">livre1</a></li>
                        <li data-id="2" class="list-item"><a href="#">livre2</a></li>
                        <li data-id="3" class="list-item"><a href="#">livre3</a></li>
                        <li data-id="4" class="list-item"><a href="#">livre4</a></li>
                    </ul>
                </div>
                <div class="column">
                    <ul id="listTo1" class="nav nav-pills nav-stacked"></ul>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="column">
                    <input type="text" id="hidden1" class="form-control" readonly/>
                </div>
                <input type="submit" id="submit1" value="Emprunter" class="btn btn-success"/>
            </div>
        </div>
    </form>

    <form method="POST" action="../borrowDocument">
        <div class="main-container column">
            <p>Rendre un document</p>
            <div class="row">
                <div class="column">
                    <ul id="listFrom2" class="nav nav-pills nav-stacked">
                        <li data-id="1" class="list-item"><a href="#">livre1</a></li>
                        <li data-id="2" class="list-item"><a href="#">livre2</a></li>
                        <li data-id="3" class="list-item"><a href="#">livre3</a></li>
                        <li data-id="4" class="list-item"><a href="#">livre4</a></li>
                    </ul>
                </div>
                <div class="column">
                    <ul id="listTo2" class="nav nav-pills nav-stacked"></ul>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="column">
                    <input type="text" id="hidden2" class="form-control" readonly/>
                </div>
                <input type="button" id="submit2" value="Rendre" class="btn btn-success"/>
            </div>
        </div>
    </form>

</div>
<a href="http://google.com">
    <img class="power-off-icon" src="../assets/power-icon.png" width="40" height="40"/></a>


</body>

</html>