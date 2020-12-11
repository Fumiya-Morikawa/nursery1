package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataAccessBean;
import bean.DiaryInfo;


@WebServlet(name = "RegistServlet", urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		try {
		    String date = request.getParameter("date");
    	    String name = request.getParameter("name");
    	    String aim = request.getParameter("aim");
	    	String contents = request.getParameter("contents");
	    	
	    	if(date == null || date.length() < 1){
	    		request.setAttribute("message", "※ 記入されていない項目があります");
	    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/regist.jsp");
	    		rd.forward(request, response);
	    		return;
	    	}
	    	if(name == null || name.length() < 1){
	    		request.setAttribute("message", "※ 記入されていない項目があります");
	    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/regist.jsp");
	    		rd.forward(request, response);
	    		return;
	    	}
	    	if(aim == null || aim.length() < 1){
	    		request.setAttribute("message", "※ 記入されていない項目があります");
	    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/regist.jsp");
	    		rd.forward(request, response);
	    		return;
	    	}
	    	if(contents == null || contents.length() < 1){
	    		request.setAttribute("message", "※ 記入されていない項目があります");
	    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/regist.jsp");
	    		rd.forward(request, response);
	    		return;
	    	}

		    DiaryInfo diaryInfo = new DiaryInfo();
		    diaryInfo.setDate(date);
		    diaryInfo.setName(name);
		    diaryInfo.setAim(aim);
		    diaryInfo.setContents(contents);

		    DataAccessBean dab = new DataAccessBean();
		    dab.registDiaryInfo(diaryInfo);

		    response.sendRedirect(request.getContextPath() + "/FindAllServlet");
		}

		catch(SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}
