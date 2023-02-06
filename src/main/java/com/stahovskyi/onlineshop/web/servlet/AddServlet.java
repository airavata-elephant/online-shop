package com.stahovskyi.onlineshop.web.servlet;

import com.stahovskyi.onlineshop.entity.Product;
import com.stahovskyi.onlineshop.entity.Session;
import com.stahovskyi.onlineshop.service.ProductService;
import com.stahovskyi.onlineshop.service.SecurityService;
import com.stahovskyi.onlineshop.util.PageGenerator;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.HashMap;

import static com.stahovskyi.onlineshop.web.mapper.ProductRequestMapper.toProduct;
import static com.stahovskyi.onlineshop.web.util.RequestUtil.getRequestToken;

@AllArgsConstructor
public class AddServlet extends HttpServlet {
    private final PageGenerator pageGenerator = PageGenerator.instance();
    private final ProductService productService;
    private final SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session session = securityService.getSession(getRequestToken(request));
        HashMap<String, Object> pageData = new HashMap<>();

        pageData.put("userRole", session.getUser().getRole());
        response.getWriter()
                .println(pageGenerator.getPage("add_product.html", pageData));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = toProduct(request);
        productService.addProduct(product);

        response.sendRedirect("/products");
    }
}
