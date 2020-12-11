package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DiaryInfo;


@WebServlet(name = "ViewServlet", urlPatterns = "/ViewServlet")

public class ViewServlet extends HttpServlet {
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

			DiaryInfo viewDiaryInfo = new DiaryInfo();
			viewDiaryInfo.setId(id);
			viewDiaryInfo.setDate(date);
			viewDiaryInfo.setName(name);
			viewDiaryInfo.setAim(aim);
			viewDiaryInfo.setContents(contents);

			request.setAttribute("viewDiaryInfo", viewDiaryInfo);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/view.jsp");
			rd.forward(request, response);
		}

		catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}
