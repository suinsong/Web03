
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberDAO;
import kr.bit.mem.MemberVO;

@WebServlet("/mInsert.do")
public class MemberInsertController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// form에서 넘어온 parameter를 받는 작업
		String irum = request.getParameter("irum");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String intro = request.getParameter("intro");

		// MemberVO에 담아줘야함
		MemberVO vo = new MemberVO();
		vo.setIrum(irum);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setIntro(intro);

		// db에 저장하기 :model과 연동(MemberDAO):Model과 연동(MemberDAO)-->JDBC
		MemberDAO dao = new MemberDAO();
		dao.memInsert(vo);
	}

}
