<%@include file="Header.jsp"%>

<div class ="container">
	<table align = "center" class = "table">
		<tr>
			<td rowspan ="10">
			<a href="<c:url value="/productDisplay/${product.productId }"/>
				<img src="resources/${product.productId}.jpg"width=100% "/>
			</td>
		</tr>	
		<tr>
			<td>Product ID</td>
			<td>${product.productId }</td>
		</tr>
		
		<tr>
			<td>Price</td>
			<td>${product.productPrice }</td>
		</tr>
		
		
		<tr>
			<td>Stock</td>
			<td>${product.productQuantity }</td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td>${product.productDescription }</td>
		</tr>
		<form action = "<c:url value="/addToCart/${product.productId }"/>" method="GET">
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add To Cart" class="btn btn-info"/></td>
			</tr>
		</form>
	</table>
</div>
<%@include file="Footer.jsp"%>