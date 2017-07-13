
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.mem.MemberVO;

@WebServlet("/cs.do")
public class CalcServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));

		int sum = 0;

		for (int i = su1; i <= su2; i++) {

			sum += i;

		}
*/
		// -----------------------------------------

		MemberVO vo = new MemberVO();
		vo.setNum(1);
		vo.setIrum("ȫ�浿");
		vo.setAge(36);
		vo.setEmail("gildong@hanmail.net");
		vo.setIntro("�ڱ�Ұ��Դϴ�");
		
		List<MemberVO> list = new ArrayList<MemberVO>();

		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		
		//�ڡڡڡڡ�json������ ���·� �����������======>GSON�� �ʿ���!!!!!�ڡڡڡڡڡ�
		Gson g=new Gson();
		String json= g.toJson(list);
		response.setContentType("text/json;charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
