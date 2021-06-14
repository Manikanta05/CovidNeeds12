package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.*;

import entity.*;

@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		/*case "listusers":
			listUsers(request, response);
			break;*/
		case "adduser":
			addUserFormLoader(request, response);
			break;
		case "login":
			loginFormLoader(request, response);
			break;
		case "signup":
			signupFormLoader(request, response);
			//orgFormLoader(request, response);
			break;
		case "org":
			orgFormLoader(request, response);
			break;
		case "user":
			userFormLoader(request, response);
			break;
		 case "updatereq":
			 Requirements vro1=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"),request.getParameter("rtype"),request.getParameter("ogname"),request.getParameter("ogemail"),request.getParameter("status"));
				String name4=request.getParameter("name");
				String email4=request.getParameter("email");
				String type4=request.getParameter("type");
				request.setAttribute("name", name4);
				request.setAttribute("email", email4);
				request.setAttribute("type", type4);
				updateReq(request,response,vro1);	
			break;
		/*case "deleteuser":	
		     deleteUser(Integer.parseInt(request.getParameter("usersId")));
		     listUsers(request, response);
		     break;*/
		
		default:
			errorPage(request, response);
		}

	}

	/*private void deleteUser(int usersID) {
		new LoginModel().deleteUser(dataSource,usersID);
		return;
	}

	private void UpdateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update User");
		try {
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operation = request.getParameter("form");
		//System.out.println("came1"+operation+"abcd");
		operation = operation.toLowerCase();
		switch (operation) {
		case "adduseroperation":
			Login newUser = new Login(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"),request.getParameter("type"));
			//System.out.println(name);
			String abc=addUserOperation(newUser);
			//System.out.println("User added");
			String type=request.getParameter("type");
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			//System.out.println(type);
			if(abc=="normal") {
			if("user".equals(type)) {
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("type", type);
			userFormLoader(request,response);}
			else {
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("type", type);
			orgFormLoader(request, response);}}
			else
			{
				errorPage(request, response);
			}
		
			break;
		case "loginuseroperation":
			//System.out.println("11111");
			Login newUser1 = new Login(request.getParameter("email"),request.getParameter("password"));
			//String name1=request.getParameter("name");
			//System.out.println(name1);
			Login flag=loginUserOperation(newUser1);
			//System.out.println("abcd"+flag.getType());
			if(flag.getType().equals("user"))
			{
				String name1=flag.getName();
				String email1=flag.getEmail();
				String type1=flag.getType();
				//System.out.println("abcd"+name1);
				request.setAttribute("name", name1);
				request.setAttribute("email", email1);
				request.setAttribute("type", type1);
				userFormLoader(request,response);
			}
			else if(flag.getType().equals("org"))
			{
				String nameog=flag.getName();
				String emailog=flag.getEmail();
				String typeog=flag.getType();
				request.setAttribute("name", nameog);
				request.setAttribute("email", emailog);
				request.setAttribute("type", typeog);
				//System.out.println("abcd"+flag.getType());
				orgFormLoader(request,response);
			}
			else
			{
				errorPage(request, response);
			}
			
			break;
			
		case "requseroperation":
			Requirements newreq=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"),request.getParameter("rtype"),request.getParameter("comment"));
			String comm=request.getParameter("comment");
			String rtype=request.getParameter("rtype");
			//System.out.println(comm+rtype);
			String flag1=reqUserOperation(newreq);
			//System.out.println("Requserop");
			if(flag1.equals("normal"))
			{
				String name2=request.getParameter("name");
				String email2=request.getParameter("email");
				String type2=request.getParameter("type");
				request.setAttribute("name", name2);
				request.setAttribute("email", email2);
				request.setAttribute("type", type2);
				userFormLoader(request,response);
			}
			else
			{
				errorPage(request, response);
			}
			
			break;
		case "listreqoperation" :
			//System.out.println("came");
			Requirements lro=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"));
		    listReq(request,response,lro);		
		break;
		case "acceptreqoperation" :
			//System.out.println("came");
			
			Requirements aro=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"));
			String name3=request.getParameter("name");
			String email3=request.getParameter("email");
			String type3=request.getParameter("type");
			request.setAttribute("name", name3);
			request.setAttribute("email", email3);
			request.setAttribute("type", type3);
		    acceptReq(request,response,aro);		
		break;
		case "viewreqoperation" :
			//System.out.println("came");
			Requirements vro=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"));
		    viewReq(request,response,vro);		
		break;
		case "updatereqoperation" :
			//System.out.println("came");
			//Requirements vro1=new Requirements(request.getParameter("name"),request.getParameter("email"),request.getParameter("type"),request.getParameter("rtype"),request.getParameter("ogname"),request.getParameter("ogemail"));
			String name4=request.getParameter("name");
			String email4=request.getParameter("email");
			String type4=request.getParameter("type");
			request.setAttribute("name", name4);
			request.setAttribute("email", email4);
			request.setAttribute("type", type4);
			//updateReq(request,response,vro1);		
		break;
		/*case "updateuseroperation":
			Login updatedUser = new Login(Integer.parseInt(request.getParameter("usersId")),
					request.getParameter("username"), request.getParameter("email"));
			updateUserOperation(dataSource, updatedUser);
			listUsers(request, response);
			break;*/
		default:
			errorPage(request, response);
			break;
		}
	}

	public void acceptReq(HttpServletRequest request, HttpServletResponse response,Requirements lro)
			throws ServletException, IOException {
		List<Requirements> listUsers = new ArrayList<>();
		listUsers = new ReqModel().acceptReq(dataSource,lro);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List of requests");
		String name=(String)request.getAttribute("name");
		String email=(String)request.getAttribute("email");
		String type=(String)request.getAttribute("type");
		//System.out.println(name+request.getAttribute("name"));
		request.setAttribute("name", name);
		request.setAttribute("email",email);
		request.setAttribute("type", type);
		request.getRequestDispatcher("ar.jsp").forward(request, response);
	}
	public void viewReq(HttpServletRequest request, HttpServletResponse response,Requirements lro)
			throws ServletException, IOException {
		List<Requirements> listUsers = new ArrayList<>();
		listUsers = new ReqModel().viewReq(dataSource,lro);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List of requests");
		request.getRequestDispatcher("vr.jsp").forward(request, response);
	}
	public void listReq(HttpServletRequest request, HttpServletResponse response,Requirements lro)
			throws ServletException, IOException {
		List<Requirements> listUsers = new ArrayList<>();
		listUsers = new ReqModel().listReq(dataSource,lro);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List of requests");
		request.getRequestDispatcher("lor.jsp").forward(request, response);
	}
	public void updateReq(HttpServletRequest request, HttpServletResponse response,Requirements lro)
			throws ServletException, IOException {
		
		String abc = new ReqModel().updateReq(dataSource,lro);
		String name=(String)request.getAttribute("name");
		String email=(String)request.getAttribute("email");
		String type=(String)request.getAttribute("type");
		//System.out.println(name+request.getAttribute("name"));
		request.setAttribute("name", name);
		request.setAttribute("email",email);
		request.setAttribute("type", type);
		request.getRequestDispatcher("done.jsp").forward(request, response);
	}
	private String reqUserOperation(Requirements newUser) {
		String newuser1=new ReqModel().addReq(dataSource, newUser);
		 return "normal";
		}
	
	private String addUserOperation(Login newUser) {
		String abc=new LoginModel().addUser(dataSource, newUser);
		if(abc=="normal")
			return "normal";
		else		
		return "abnormal";
	}
	private Login loginUserOperation(Login newUser) {
	 Login newuser1=new LoginModel().loginUser(dataSource, newUser);
	 return newuser1;
	}
	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);

	}
	public void loginFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Login");
		
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}
	public void signupFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Signup");
		request.getRequestDispatcher("signup.jsp").forward(request, response);

	}
	public void orgFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Organisation");
		String name=(String)request.getAttribute("name");
		String email=(String)request.getAttribute("email");
		String type=(String)request.getAttribute("type");
		//System.out.println(name+request.getAttribute("name"));
		request.setAttribute("name", name);
		request.setAttribute("email",email);
		request.setAttribute("type", type);
		request.getRequestDispatcher("org.jsp").forward(request, response);
	}
	public void userFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "User");
		//System.out.println(request.getParameter("name"));
		String name=(String)request.getAttribute("name");
		String email=(String)request.getAttribute("email");
		String type=(String)request.getAttribute("type");
		//System.out.println(name+request.getAttribute("name"));
		request.setAttribute("name", name);
		request.setAttribute("email",email);
		request.setAttribute("type", type);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}
}

/*private void updateUserOperation(DataSource dataSource, Login updatedUser) {
	new LoginModel().updateUser(dataSource,updatedUser);
	return;
	
}*/
/*public void listUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	List<Login> listUsers = new ArrayList<>();
	listUsers = new LoginModel().listUsers(dataSource);
	request.setAttribute("listUsers", listUsers);
	request.setAttribute("title", "List of users");
	request.getRequestDispatcher("listUser.jsp").forward(request, response);

}*/