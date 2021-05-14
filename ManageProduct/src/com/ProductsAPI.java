package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/ProductsAPI")
public class ProductsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product productObj = new Product();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsAPI() {
        super();
        // TODO Auto-generated constructor stub
        
        //itemObj = new Item();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		String output = productObj.insertProduct(request.getParameter("productCode"),
				 request.getParameter("productName"),
				request.getParameter("productPrice"),
				request.getParameter("productDesc"));
				response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
Map paras = getParasMap(request);
		
		String output = productObj.updateProduct(paras.get("hidProductIDSave").toString(), paras.get("productCode").toString(), 
				paras.get("productName").toString(), paras.get("productPrice").toString(), paras.get("productDesc").toString());
		
		response.getWriter().write(output); 
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		 String output = productObj.deleteProduct(paras.get("productID").toString());
		response.getWriter().write(output);
		
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
		 String[] p = param.split("=");
		 map.put(p[0], p[1]);
		 }
		 }
		catch (Exception e)
		 {
		 }
		return map;
		}
	 }

