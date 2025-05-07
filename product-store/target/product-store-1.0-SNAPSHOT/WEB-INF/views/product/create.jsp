<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<main class="container">
  <h1 class="mb-3">Create New Product</h1>
  <a href="./products" class="btn btn-purple">Back to Product List</a>

  <form class="mt-3" action="" method="post">
    <div class="row">
      <div class="col-6">
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input
            class="form-control ${errors.getFieldError('name') != null ? 'is-invalid' : ''}"
            type="text"
            id="name"
            name="name"
            value="${product != null ? product.name : ''}"
            placeholder="Product Name"
          />
          <div class="form-text text-danger">
            ${errors.getFieldError("name") != null ?
            errors.getFieldError("name").getDefaultMessage() : ""}
          </div>
        </div>
        <div class="mb-3">
          <label class="form-label" for="price">Price</label>
          <input
            class="form-control ${errors.getFieldError('price') != null ? 'is-invalid' : ''}"
            type="number"
            id="price"
            name="price"
            value="${product != null ? product.price : '0'}"
          />
          <div class="form-text text-danger">
            ${errors.getFieldError("price") != null ?
            errors.getFieldError("price").getDefaultMessage() : ""}
          </div>
        </div>
        <div class="mb-3">
          <label class="form-label" for="stock">Stock</label>
          <input
            class="form-control ${errors.getFieldError('stock') != null ? 'is-invalid' : ''}"
            type="number"
            id="stock"
            name="stock"
            value="${product != null ? product.stock : '0'}"
          />
          <div class="form-text text-danger">
            ${errors.getFieldError("stock") != null ?
            errors.getFieldError("stock").getDefaultMessage() : ""}
          </div>
        </div>
      </div>
      <div class="col-6">
        <div class="mb-3">
          <label class="form-label" for="category">Category</label>
          <select
            class="form-select ${errors.getFieldError('category') != null ? 'is-invalid' : ''}"
            id="category"
            name="categoryId"
          >
            <option value="" disabled selected>Select a category</option>
            <c:forEach var="category" items="${categories}">
              <option value="${category.id}"
                ${product != null && product.categoryId == category.id ? 'selected' : ''}>
                ${category.name}
              </option>
            </c:forEach>
          </select>
          
          <%-- <input
            class="form-control ${errors.getFieldError('category') != null ? 'is-invalid' : ''}"
            type="text"
            id="category"
            name="category"
            value="${product != null ? product.category : ''}"
          /> --%>
          <div class="form-text text-danger">
            ${errors.getFieldError("category") != null ?
            errors.getFieldError("category").getDefaultMessage() : ""}
          </div>
        </div>
        <div class="mb-3">
          <label class="form-label" for="description">Description</label>
          <textarea
            class="form-control ${errors.getFieldError('description') != null ? 'is-invalid' : ''}"
            id="description"
            name="description"
          >
${product != null ? product.description : ''}</textarea
          >
          <div class="form-text text-danger">
            ${errors.getFieldError("description") != null ?
            errors.getFieldError("description").getDefaultMessage() : ""}
          </div>
        </div>
      </div>
    </div>

    <div class="mt-3">
      <button class="btn btn-purple" type="submit">Create Product</button>
    </div>
  </form>
</main>

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
