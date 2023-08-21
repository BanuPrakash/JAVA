package com.adobe.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// CMD + SHIFT + O

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // MIME type
		PrintWriter out = response.getWriter(); // open character stream to Browser / client
		// PrintWriter out = response.getOutputStream(); // opens byte stream to Browser --> video / image
		ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead

		out.print("<html>");
		out.print("<body>");
		out.print("<table border=\"1\">");
		out.print("<tr>");
			out.print("<th>ID</th><th>Name</th><th>Price</th>");
		out.print("</tr>");
		try {
			List<Product> products = productDao.getProducts();
			for (Product p : products) {
				out.print("<tr>"); 
					out.print("<td>" + p.getId() + "</td>");
					out.print("<td>" + p.getName() + "</td>");
					out.print("<td>" + p.getPrice() + "</td>");
				out.print("</tr>");
			}
		} catch (DaoException e) {
			e.printStackTrace(); // in development mode --> Why, What, Where
			// System.out.println(e.getMessage()); // in production mode
			out.print(e.getMessage());
		}
		out.print("</table>");
		out.print("<a href=\"index.html\">Back</a>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = Product.builder()
				.name(request.getParameter("name"))
				.price(Double.parseDouble(request.getParameter("price")))
				.quantity(100).build();
		
		ProductDao productDao = new ProductDaoJdbcImpl(); 
		try {
			productDao.addProduct(p);
			response.sendRedirect("index.html");
		} catch (DaoException e) {
			e.printStackTrace();
			// response.sendRedirect("error.html?msg=" + e.getMessage());
		}
	}

}
