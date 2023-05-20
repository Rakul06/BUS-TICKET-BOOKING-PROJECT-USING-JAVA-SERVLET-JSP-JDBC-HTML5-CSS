package BUSAP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{
	RequestDispatcher rd;
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String from=req.getParameter("from");
		String to = req.getParameter("to");
		String bus = req.getParameter("bus");
		String name= req.getParameter("name");
		String phone= req.getParameter("phone");
		String date=req.getParameter("date");
		int age= Integer.parseInt(req.getParameter("age"));
		String gender= req.getParameter("gender");
		PrintWriter out=res.getWriter();
		try {
			String name1="root";
			String password="sivakamib@06";
			String url="jdbc:mysql://localhost:3306/Bus?useSSL=false";
			Connection con=DriverManager.getConnection(url,name1,password);
			String query="insert into passengerinfo values ('"+bus+"','"+from+"','"+to+"','"+date+"','"+name+"',"+age+",'"+phone+"','"+gender+"');";
			Random r = new Random();
			String seatNum=(char)(r.nextInt(26) + 'A')+"21";
			Statement st=con.createStatement();
			st.executeUpdate(query);
			con.close();
			
			String name2="root";
			String password2="sivakamib@06";
			String url1="jdbc:mysql://localhost:3306/Bus?useSSL=false";
			Connection con1=DriverManager.getConnection(url1,name2,password2);
			String Query="insert into bookinginfo values ('"+bus+"','"+date+"');";
			Statement st1=con1.createStatement();
			st1.executeUpdate(Query);
			con1.close();
			
			req.setAttribute("Bus",bus);
			req.setAttribute("seat", seatNum);
			rd=req.getRequestDispatcher("checkseats.jsp");
			rd.forward(req, res);
		}
		catch (Exception e) {
			
		}
	}
}
