package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccessBean;
import bean.DiaryInfo;

@SuppressWarnings("serial")
@WebServlet(name = "FindAllServlet", urlPatterns= "/FindAllServlet")

public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		try {
			DataAccessBean dab = new DataAccessBean();
			Collection<DiaryInfo> diaryInfoList = dab.findAllDiaryInfo();
			request.setAttribute("diaryInfoList", diaryInfoList);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
			rd.forward(request, response);
		} 

		catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		} 

	}

}
