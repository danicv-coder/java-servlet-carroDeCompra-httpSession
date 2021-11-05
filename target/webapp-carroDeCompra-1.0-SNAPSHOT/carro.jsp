<%@page contentType="text/html" pageEncoding="UTF-8" import="org.danicv.apiservlet.webapp.httpsession.models.*"%>
<%Carro carro = (Carro) session.getAttribute("carro");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de compras</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Carro de compras</h1>
<%if(carro == null || carro.getItems().isEmpty()){%>
    <p>Lo sentimos no hay productos en el carro de compras</p>
<%}else{%>
<form action="/webapp-carroDeCompra/actulizar-carro" method"post">
    <table>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
            <th>Borrar</th>
        </tr>
        <%for(ItemCarro item: carro.getItems()){%>
        <tr>
            <td><%=item.getProducto().getId()%></td>
            <td><%=item.getProducto().getNombre()%></td>
            <td><%=item.getProducto().getPrecio()%></td>
            <td><input type="text" size"4" name="can_1" value="1"></td>
            <td><%=carro.getTotal()%></td>
            <td><input type="checkbox" value="1" name="deleteProducto"></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="4" style="text-align: right">Total:</td>
            <td><%=carro.getTotal()%></td>
        </tr>
    <table>
<%}%>
</form>
<p><a href="<%=request.getContextPath()%>/producto.html">Seguir comprando</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Volver</a></p>
</div>
</body>
</html>