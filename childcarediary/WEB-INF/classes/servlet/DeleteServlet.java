package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccessBean;


@WebServlet(name = "DeleteServlet", urlPatterns= "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");

			String id = request.getParameter("id");
			DataAccessBean dab = new DataAccessBean();
			dab.deleteDiaryInfo(id);

			response.sendRedirect(request.getContextPath() + "/FindAllServlet");
		}

		catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
