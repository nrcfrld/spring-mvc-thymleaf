<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

    <main class="container">
    <h1 class="mb-3">Product List</h1>
    <c:if test="${message != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <a href="./products/create" class="btn btn-purple">Create New Product</a>
    <table class="table w-100 mt-3">
        <thead>
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Category</th>
                <th>Desc</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${product.getProduct().name}</td>
                    <td>${product.getProduct().price}</td>
                    <td>${product.getProduct().stock}</td>
                    <td>${product.getCategory().name}</td>
                    <td>${product.getProduct().description}</td>
                    <td>
                        <a href="./products/${product.getProduct().id}/edit" class="btn btn-warning">Edit</a>
                        <form action="./products/${product.getProduct().id}" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty products}">
                <tr>
                    <td colspan="7" class="text-center">No products found</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    </main>

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
