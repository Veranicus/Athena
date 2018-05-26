<%-- 
    Document   : success
    Created on : 24.4.2018, 10:23:28
    Author     : gru100
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%-- 
    Toto je cílová stránka, pokud se mi podaří vložit údaje přes textová pole a správně
    vyplnit heslo. Příkazy níže vytahují hodnoty jednotlivých parametrů zadané
    přes textová pole a vypisují je v této stránce. Odkaz na hodnotu je pak prováděn syntaxí
    ${cesta k hodnote}. Příkaz requestScope pak použijeme, byl-li stránce odeslán požadavek 
    obsahující objekty a parametry a my z nich chceme hodnoty vytáhnout.
    --%>
        <h1>Details</h1><br/><br/>
        Name: ${requestScope.athena.name}<br/>
        Status: ${requestScope.athena.status}<br/>
        Place: ${requestScope.athena.place}<br/>
    </body>
</html>
