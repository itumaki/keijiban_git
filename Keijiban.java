package kadai;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Keijiban")
public class Keijiban extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Keijiban() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


		/** 押されたボタンにより動作を変える */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		  if (action.equals("送信")) {
			Send(request, response);
		}
	}

	void Send (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chat = request.getParameter("chat");



		HttpSession session = request.getSession();

		/** listへ*/
		List<String> message = (List<String>)session.getAttribute("message");
	if (chat != "") {
		message.add(chat);
	}
	/** クライアントからリクエストを受信*/
	RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
	dispatcher.forward(request, response);
	System.out.println(message);
	}
	/** セッションを破棄*/
	void terminateSession (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();


		/** クライアントからリクエストを受信(keijiban.jsp)*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
		dispatcher.forward(request, response);
	}


}