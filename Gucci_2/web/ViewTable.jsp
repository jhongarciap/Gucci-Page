<%-- 
    Document   : add
    Created on : 20/05/2023, 02:03:53 PM
    Author     : garci
--%>


<%@page import="java.util.List"%>
<%@page import="Model.Product"%>
<%@page import="Model.ProductDao"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/svg+xml" sizes="64x64" href="images/G-1.png" >
        <title>Admistrador - Lista de Productos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <link href="dist/css/custom.css" rel="stylesheet" type="text/css"/>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Borrar directivas de memoria cache y anular algoritmos predeterminados para almacenar cache 
            response.setHeader("Pragma", "no-cache");//Directivas compatibles con memorias cache 
            response.setDateHeader("Expires", 0);//Proporciona Fecha y hora para decir el tiempo de respuesta caduco 
        %>
    </head>
    <body class="goto-here">
        <div class="py-1 bg-img1">
            <div class="container ">
                <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
                    <div class="col-lg-12 d-block">
                        <div class="row d-flex">
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
                                <span class="text">+ 1235 2355 98</span>
                            </div>
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
                                <span class="text">Gucci@gmail.com</span>
                            </div>
                            <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                                <span class="text">ENTREGA DE 3 A 5 Dï¿½AS Hï¿½BILES&amp; Y DEVOLUCIONES GRATUITAS
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    
        <section class="ftco-section ftco-cart">
            <div class="container">
                <div class="row justify-content-center mb-3 pb-3">
                    <div class="col-md-12 heading-section text-center ftco-animate">
                        <a class="navbar-brand" href="options.html"><img src="images/LogoGucci.png" width="150" height="" alt="LogoGucci"/></a>
                        <h2 class="mb-4">Lista de productos</h2>

                    </div>
                </div>   		
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12 ftco-animate">
                        <div class="cart-list">
                            <table class="table">
                                <thead class="thead-primary">
                                    <tr class="text-center">
                                        <th>Id</th>
                                        <th>Producto</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Especificaciones</th>
                                        <th>-</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ProductDao productDao = new ProductDao();
                                        List<Product> listProduct = productDao.listProduct();
                                        request.setAttribute("list", listProduct);
                                    %>
                                    <c:forEach var="product" items="${list}">
                                        <tr>
                                            <td><c:out value="${product.code}" /></td>
                                            <td><c:out value="${product.name}" /></td>
                                            <td><c:out value="${product.amount}" /></td>
                                            <td><c:out value="${product.price}" /></td>
                                            <td><c:out value="${product.specifications}" /></td>
                                            <td><a href="ProductosController?action=delete&code=<c:out value="${product.code}" />" class="btn btn-black px-3 py-2">Eliminar</a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <a href="ViewTable.jsp" class="buy-now text-center py-2">Ir<span><i class="ion-ios-cart ml-1"></i></span></a>

            </div>
            <div class="container center">
                <div class="product d-flex flex-column">
                    <a href="ProductosController?action=add" class="btn btn-black px-3 py-2">Añadir Producto<span></span></a>
                </div>
            </div>

        </section>
        <footer class="ftco-footer ftco-section">
            <div class="container">
                <div class="row">
                    <div class="mouse">
                        <a href="#" class="mouse-icon">
                            <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
                        </a>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Gucci</h2>
                            <p>ï¿½ 2016 - 2020 Guccio Gucci S.p.A. - Todos los derechos reservados. LICENCIA SIAE # 2294/I/1936 y 5647/I/1936.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </footer>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>
        <script src="bootstrap_1/js/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="js/funtionIndex.js"></script>
        <script src="js/addfuntions.js"></script>

    </body>
</html>
