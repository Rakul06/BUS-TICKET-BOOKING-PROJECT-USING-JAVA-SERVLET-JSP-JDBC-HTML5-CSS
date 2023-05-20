package BUSAP;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class booking extends HttpServlet{
	RequestDispatcher rd;
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		String date=req.getParameter("date");
		int count=0;
		String bus="";
		int seatcapcity=0;
		PrintWriter out=res.getWriter();
		
		try {
				String name1="root";
				String password="sivakamib@06";
				String url1="jdbc:mysql://localhost:3306/Bus?useSSL=false";
				Connection con1=DriverManager.getConnection(url1,name1,password);
				String query1="select busno,seats from businfo where from_='"+from+"' and to_='"+to+"';";
				Statement st=con1.createStatement();
				ResultSet rs1=st.executeQuery(query1);
				while(rs1.next()) {
					bus=(rs1.getString(1));
					seatcapcity=(rs1.getInt(2));
				}
				con1.close();
				
				if(seatcapcity!=0) {
					String name="root";
					String password1="sivakamib@06";
					String url="jdbc:mysql://localhost:3306/Bus?useSSL=false";
					Connection con=DriverManager.getConnection(url,name,password1);
					String query="select count(*) from bookinginfo where date='"+date+"' and busno='"+bus+"';";
					Statement pst=con.createStatement();
					ResultSet rs=pst.executeQuery(query);
					while(rs.next()) {
						count=rs.getInt(1);
					}
					con.close();
				}
				
				if(seatcapcity>count) {
					req.setAttribute("from",from);
					req.setAttribute("to", to);
					req.setAttribute("busno", bus);
					req.setAttribute("status", "true");
					req.setAttribute("date", date);
					rd=req.getRequestDispatcher("booking.jsp");
				}
				else {
					rd=req.getRequestDispatcher("noseats.jsp");
				}
			rd.forward(req, res);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
