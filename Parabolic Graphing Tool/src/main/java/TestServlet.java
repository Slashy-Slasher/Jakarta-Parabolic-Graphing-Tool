import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private Model model = new Model();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.sendRedirect("http://localhost:8080/WebAppExample/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getParameter("type").equals("0"))
		{
			response.setContentType("text/html");
		    String num1 = request.getParameter("x-input");
		    String num2 = request.getParameter("y-input");
		    model.createFile();
		    model.createCSV(num1, num2);
		    //model.createPng();
		    response.sendRedirect("http://localhost:8080/WebAppExample/graph.html");
		    //response.sendRedirect("http://localhost:8080/WebAppExample/userCsv.csv");
		}
		if(request.getParameter("type").equals("1"))
		{
			model.createCSV("0", "0");
		    response.sendRedirect("http://localhost:8080/WebAppExample/");
		}
				
	}

}
