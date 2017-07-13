
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

		// form���� �Ѿ�� parameter�� �޴� �۾�
		String irum = request.getParameter("irum");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String intro = request.getParameter("intro");

		// MemberVO�� ��������
		MemberVO vo = new MemberVO();
		vo.setIrum(irum);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setIntro(intro);

		// db�� �����ϱ� :model�� ����(MemberDAO):Model�� ����(MemberDAO)-->JDBC
		MemberDAO dao = new MemberDAO();
		dao.memInsert(vo);
	}

}
