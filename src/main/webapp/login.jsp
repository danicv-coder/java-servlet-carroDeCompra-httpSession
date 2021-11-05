<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Ingrese sus credenciales para ingresar</h1>
    <div>
        <form action="/webapp-carroDeCompra/login" method="post">
            <div>
                <label for="username">Nombre:</label>
                <input type="text" name="username" id="username">
            </div>

            <div>
                <label for="password">Contraseña:</label>
                <input type="text" name="password" id="password">
            </div>
            <div>
                <button class="btn btn-dark" type="submit" value="Enviar">Enviar</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>