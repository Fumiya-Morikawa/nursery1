package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccessBean;
import bean.DiaryInfo;


@WebServlet(name = "UpdateServlet2", urlPatterns ="/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		try {
			String id = request.getParameter("id");
		    String date = request.getParameter("date");
    	    String name = request.getParameter("name");
    	    String aim = request.getParameter("aim");
	    	String contents = request.getParameter("contents");

		    DiaryInfo diaryInfo = new DiaryInfo();
		    diaryInfo.setId(id);
		    diaryInfo.setDate(date);
		    diaryInfo.setName(name);
		    diaryInfo.setAim(aim);
		    diaryInfo.setContents(contents);

		    DataAccessBean dab = new DataAccessBean();
		    dab.updateDiaryInfo(diaryInfo);

		    response.sendRedirect(request.getContextPath() + "/FindAllServlet");
		}

		catch(SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}
