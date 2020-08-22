<%@include file="Header.jsp"%>
<html>
<head></head>
<body>
<h2><center>Welcome ${sessionScope.username } !</center></h2>
<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="<c:url value="/productCatalog"/>">
        <img src="<c:url value="https://i.gadgets360cdn.com/products/large/1552901002_635_redmi_7.jpg"/>" alt="Lights" style="width:100%">
        <div class="caption">
          <p><h2>Xiomi</h2></p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="<c:url value="/productCatalog"/>">
        <img src="<c:url value="https://i01.appmifile.com/webfile/globalimg/in/cms/DFF8E0CE-D61C-6474-3F2D-831B25D07187.jpg"/>" alt="Lights" style="width:100%">
        <div class="caption">
          <p><h2>Redme note 8</h2></p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="<c:url value="/productCatalog"/>">
        <img src="<c:url value="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQSWNbsJj5zAjbv5PY8fRkcMfs2xzmiuRBolg&usqp=CAU"/>" alt="Lights" style="width:100%">
        <div class="caption">
          <p><h2>Vivo</h2></p>
        </div>
      </a>
    </div>
  </div>
 </div>

</body>
<%@include file="Footer.jsp"%>
</html>