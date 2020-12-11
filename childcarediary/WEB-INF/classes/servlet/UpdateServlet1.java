package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DiaryInfo;


@WebServlet(name = "UpdateServlet1", urlPatterns = "/UpdateServlet1")

public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		try{
			String id = request.getParameter("id");
			String date = request.getParameter("date");
			String name = request.getParameter("name");
			String aim = request.getParameter("aim");
			String contents = request.getParameter("contents");

			DiaryInfo updateDiaryInfo1 = new DiaryInfo();
			updateDiaryInfo1.setId(id);
			updateDiaryInfo1.setDate(date);
			updateDiaryInfo1.setName(name);
			updateDiaryInfo1.setAim(aim);
			updateDiaryInfo1.setContents(contents);

			request.setAttribute("updateDiaryInfo1", updateDiaryInfo1);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
			rd.forward(request, response);
		}

		catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}
