package com.easy.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.easy.main.dao.BoardDAO;
import com.easy.main.dao.MemberDAO;
import com.easy.main.dto.BComPageDto;
import com.easy.main.dto.BCommentDto;
import com.easy.main.dto.BDto;
import com.easy.main.dto.BSearchDto;
import com.easy.main.dto.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;






/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/fileTest", method = RequestMethod.POST)
	public String fileTest(MultipartFile uploadFile) {
		
		try{
			
		uploadFile.transferTo(new File("D:/File/"+uploadFile.getOriginalFilename()));
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "home";
	}
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public String downloadFile(HttpServletResponse response) {
		
		response.setHeader("Content-Disposition", "attachment;filename=Mybatis.zip");
		
		try {
			FileInputStream fis=new FileInputStream(new File("D:/File/Mybatis.zip"));
			ServletOutputStream sos=response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}




	
	
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request,	HttpServletResponse response) {
		String url = "/member/login";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) {// 이미로그인된 사용자라면
			url = "/member/index_member"; // 메인페이지로 이동합니다
		}
		return url;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginDo(Locale locale, Model model, HttpServletRequest request,	HttpServletResponse response) {
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");

		String url=null;

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(memId, memPwd);

		
		if(result == 2){
			MemberVO mVo = new MemberVO();
			mVo = mDao.getMember(memId);
			String memName = mVo.getMemName();
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memId);	
			session.setAttribute("loginUser_Name", memName);	
			session.setAttribute("result", result);		

			url = "/member/index_member";				

		}else if(result == 3){
			MemberVO mVo = new MemberVO();
			mVo = mDao.getMember(memId);
			String memName = mVo.getMemName();

			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", memId);	
			session.setAttribute("loginUser_name", memName);	
			session.setAttribute("result", result);		

			url = "/member/index_admin";				

		}else{
			url = "/member/login";
			request.setAttribute("message", "로그인 실패 ! 아이디 or 비밀번호를 확인하세요");

		}
		return url;
	}
	
	@RequestMapping(value = "/index_admin", method = RequestMethod.GET)
	public String index_admin(Locale locale, Model model) {
		return "/member/index_admin";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}
	
	// 표광진 
	// 공지사항 리스트 가져오기	
	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	public String listSearch(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");
		if(page==null) {
			page="1";
		}
		if(pageDataCount==null) {
			pageDataCount="20";
		}
		String searchCol=(String)request.getParameter("searchCol");
		String searchVal=(String)request.getParameter("searchVal");
		System.out.println("String searchCol=(String)request.getParameter(\"searchCol\"); " + searchCol );
		System.out.println("String searchVal=(String)request.getParameter(\"searchVal\"); " + searchVal );

		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}

		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);
		
		
		BoardDAO bDao=new BoardDAO();
		ArrayList<BDto> dtos
		=bDao.searchSelect(page,pageDataCount,searchCol,searchVal);
		request.setAttribute("dtos", dtos);				
		
		int totalDataCount=bDao.dataCount(searchCol,searchVal);
		BSearchDto bSearchDto=new BSearchDto();
		bSearchDto.makePage(Integer.parseInt(page)
				, Integer.parseInt(pageDataCount)
				, totalDataCount,searchCol,searchVal);
		request.setAttribute("bSearchDto", bSearchDto);
		
		System.out.println(bSearchDto);
		
		return "/board/listSearch";
	}
	
	@RequestMapping(value = "/listSearch", method = RequestMethod.POST)
	public String listSearching(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
	
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");
		if(page==null) {
			page="1";
		}
		if(pageDataCount==null) {
			pageDataCount="20";
		}
		String searchCol=(String)request.getParameter("searchCol");
		String searchVal=(String)request.getParameter("searchVal");
		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}

		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);
		
		
		BoardDAO bDao=new BoardDAO();
		ArrayList<BDto> dtos
		=bDao.searchSelect(page,pageDataCount,searchCol,searchVal);
		request.setAttribute("dtos", dtos);				
		
		int totalDataCount=bDao.dataCount(searchCol,searchVal);
		BSearchDto bSearchDto=new BSearchDto();
		bSearchDto.makePage(Integer.parseInt(page)
				, Integer.parseInt(pageDataCount)
				, totalDataCount,searchCol,searchVal);
		request.setAttribute("bSearchDto", bSearchDto);
		
		

//		String page = request.getParameter("page");
//		String searchCol = request.getParameter("searchCol");
//		String searchVal = request.getParameter("searchVal");
//		String pageDataCount = request.getParameter("pageDataCount");		
//		return "redirect:/bContentCommand?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
		
		System.out.println(bSearchDto);
		return "/board/listSearch";
	}
	
	// 공지사항 내용 가져오기
	@RequestMapping(value = "/bContentCommand", method = RequestMethod.GET)
	public String bContentCommand(Locale locale, Model model, HttpServletRequest request){
		
		
		String bId=request.getParameter("bId");

		System.out.println("String bId ==" + bId);
		
		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);
			System.out.println("컨텐트에서 dto.bFile ==" + dto.getbFile());
	
		
/////////////////////////////////////////////////////////		// TODO Auto-generated method stub
		
//		String bId=request.getParameter("bId");
//		BoardDAO dao=new BoardDAO();		
//		BDto dto=dao.select(bId);		
		request.setAttribute("dto", dto);
			
		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);
		

		System.out.println("BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("BContentCommand bPageDataCount == "+bPageDataCount);
		
		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));
		
		// 여기서부터는 답글에 있는거 가져오는 법
		System.out.println("String bId ==" + bId);
		
		request.setAttribute("bSearchDto", bSearchDto);
		
		
		
		// 댓글 페이지
		String page=(String)request.getParameter("pageCo");
		String pageDataCount=(String)request.getParameter("pageCoDataCount");
		if(page==null) {
			page="1";
		}
		
		if(pageDataCount==null) {
			pageDataCount="20";
		}
//		
		System.out.println("댓글 pageCo="+page+"입니다.");
		System.out.println("댓글 pageDataCount="+pageDataCount+"입니다.");
		BoardDAO bDao=new BoardDAO();
		

		System.out.println("String bId ==" + bId);
		List<BCommentDto> bcommentDtoList=bDao.searchCoSelect(page,pageDataCount,bId);		
		request.setAttribute("bcommentDtoList", bcommentDtoList);

		
		int totalCoDataCount=bDao.dataCoCount(bId);
		BComPageDto bComPageDto=new BComPageDto();
		
		System.out.println("totalCoDataCount" + Integer.parseInt(page));
		System.out.println("Integer.parseInt(pageDataCount)" + Integer.parseInt(pageDataCount));
		System.out.println("totalCoDataCount"+totalCoDataCount);
		
		bComPageDto.makeCoPage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalCoDataCount);
		request.setAttribute("bComPageDto", bComPageDto);
		

		System.out.println(bComPageDto);	
		
		
		return "/board/content";
		

	}
	@RequestMapping(value = "/write_view", method = RequestMethod.GET)
	public String write_view(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "/board/write";
	}
	
//	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
//
//	public String submitReport2(MultipartHttpServletRequest request) {
//		String studentNumber = request.getParameter("studentNumber");
//		MultipartFile report = request.getFile("report");
////		printInfo(studentNumber, report);
//		return "report/submissionComplete";
//	}



	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
//      화일 올리는 경로 주는법
		

//		String path = (String) request.getAttribute("path");
		// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
//		String path = request.getSession().getServletContext().getRealPath("images");
		// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
		// String path = "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200806EazyandClean\\image";
//		String path = "D:\\SPRING\\springSTS2020\\Workspace\\20200806EazyandClean\\src\\main\\webapp\\resources\\boardImage";
		String path = "D:\\SPRING\\springSTS2020\\Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200806EazyandClean\\image";
		System.out.println(path);
	
		int maxSize = 500*1024*1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(
				
				request,
				path,
				maxSize,
				enctype,
				policy
				
		);
		//DAO 객채 생성 및 insert	
		BoardDAO dao=new BoardDAO();
		String bName=multi.getParameter("bName");
		System.out.println("bName"+bName);
		String bTitle=multi.getParameter("bTitle");
		System.out.println("bTitle"+bTitle);
		String bContent=multi.getParameter("bContent");
		System.out.println("bContent"+bContent);
		String bFile=multi.getFilesystemName("bFile");
		System.out.println("bFile"+bFile);
		dao.insert(bName,bTitle,bContent,bFile);
		
		request.setAttribute("path", path);
		
		return "redirect:/listSearch";		
	}
	
	@RequestMapping(value = "/modefy_view", method = RequestMethod.GET)
	public String modefy_view(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		BoardDAO dao = new BoardDAO();
		BDto dto = dao.select(bId);
		System.out.println("수정에서의 dto.bFile ==" + dto.getbFile());

/////////////////////////////////////////////////////////		// TODO Auto-generated method stub

		request.setAttribute("dto", dto);

		BSearchDto bSearchDto = new BSearchDto();
		int currentPageNum = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount = Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);

		System.out.println("BContentCommand currentPageNum == " + currentPageNum);
		System.out.println("BContentCommand bPageDataCount == " + bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		request.setAttribute("bSearchDto", bSearchDto);
		
		return "/board/modefy";
	}
	
	@RequestMapping(value = "/modefy", method = RequestMethod.POST)
	public String modefy(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
//      화일 올리는 경로 주는법		
//		ServletContext context = getServletContext();
//		String path = (String) request.getAttribute("path");
		// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
//		String path = request.getServletContext().getRealPath("images");
		// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
		// String path =
		// "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200702movie\\images";
		String path = "D:\\SPRING\\springSTS2020\\Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200806EazyandClean\\image";
		System.out.println(path);

		int maxSize = 500 * 1024 * 1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(

				request, path, maxSize, enctype, policy

		);
	
		// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		BoardDAO dao = new BoardDAO();
		String bId = multi.getParameter("bId");
		System.out.println("bName" + bId);
		String bTitle = multi.getParameter("bTitle");
		System.out.println("bTitle" + bTitle);
		String bContent = multi.getParameter("bContent");
		System.out.println("bContent" + bContent);
		String bFile = multi.getFilesystemName("bFile");
		System.out.println("bFile" + bFile);

		
	
		if(multi.getFilesystemName("bFile")==null) {
			bFile = multi.getParameter("nonmakeimg");
		}else {
			bFile = multi.getFilesystemName("bFile");		
		}
		
		
		dao.update(bId, bTitle, bContent, bFile);
		BDto dto = dao.select(bId);
		request.setAttribute("dto", dto);
		System.out.println("수정에서의 dto.bFile ==" + dto.getbFile());
		

//		BSearchDto bSearchDto = new BSearchDto();
//		int currentPageNum = Integer.parseInt(request.getParameter("page"));
//		System.out.println(currentPageNum);
//		bSearchDto.setCurrentPageNum(currentPageNum);
//		int bPageDataCount = Integer.parseInt(request.getParameter("pageDataCount"));
//		bSearchDto.setPageDataCount(bPageDataCount);
//		System.out.println(currentPageNum);
//
//		System.out.println("BContentCommand currentPageNum == " + currentPageNum);
//		System.out.println("BContentCommand bPageDataCount == " + bPageDataCount);
//
//		bSearchDto.setSearchCol(request.getParameter("searchCol"));
//		bSearchDto.setSearchVal(request.getParameter("searchVal"));
//
//		request.setAttribute("bSearchDto", bSearchDto);
		

		///////////////////////////////////////////////////////////////////////

		return "redirect:/listSearch";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		String bId=request.getParameter("bId");
		BoardDAO dao=new BoardDAO();
		dao.delete(bId);
		return "redirect:/listSearch";
	}
	
	// 답글 달기 
	@RequestMapping(value = "/BCommentInsert", method = RequestMethod.POST)
	public String BCommentInsert(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String url = "bContentCommand.do";
		BCommentDto bcommentDto = new BCommentDto();
		bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
		bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
		bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));
			
		System.out.println("답글달기 답글등록 누르기");		
		BoardDAO BDao = new BoardDAO();
		BDao.insertBoardComment(bcommentDto);
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm		
		String bId=request.getParameter("bId");
		System.out.println("사사나String bId ==" + bId);
		
		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);
//		System.out.println("dto.bFile ==" + dto.getbFile());
		
		request.setAttribute("dto", dto);
		
		BSearchDto bSearchDto=new BSearchDto();
	;
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		

		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);
		
				

		System.out.println("사사나BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("나나사BContentCommand bPageDataCount == "+bPageDataCount);
		

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));
		
		request.setAttribute("bSearchDto", bSearchDto);		
		System.out.println("request.setAttribute(bId, "+ bId+")");

		String page = request.getParameter("page");
		String searchCol = request.getParameter("searchCol");
		String searchVal = request.getParameter("searchVal");
		String pageDataCount = request.getParameter("pageDataCount");
		
		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}
		
		System.out.println("String page = request.getParameter(\"page\"); " +page);
		System.out.println("String searchCol = request.getParameter(\"searchCol\") ;"+searchCol);
		System.out.println("String searchVal = request.getParameter(\"searchVal\") ;"+searchVal);
		System.out.println("String pageDataCount = request.getParameter(\"pageDataCount\") ;"+pageDataCount);
		
		return "redirect:/bContentCommand?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
		
	}
	
	@RequestMapping(value = "/BCommentReplyInsert", method = RequestMethod.POST)
	public String BCommentReplyInsert(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String url = "bContentCommand.do";
		BCommentDto bcommentDto = new BCommentDto();
		bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
		bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
		bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));
		System.out.println(" request.getParameter(\"NOTICE_COMMENT_GROUPID\")) " + request.getParameter("NOTICE_COMMENT_GROUPID"));
		bcommentDto.setNOTICE_COMMENT_GROUPID(Integer.parseInt(request.getParameter("NOTICE_COMMENT_GROUPID")));
		bcommentDto.setNOTICE_COMMENT_INDENT(Integer.parseInt(request.getParameter("NOTICE_COMMENT_INDENT")));
		bcommentDto.setNOTICE_COMMENT_STEP(Integer.parseInt(request.getParameter("NOTICE_COMMENT_STEP")));
		
		System.out.println("답글달기 답글등록 누르기");		
		BoardDAO BDao = new BoardDAO();
		BDao.insertBoardCommentReply(bcommentDto);
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm		
		String bId=request.getParameter("bId");
		System.out.println("사사나String bId ==" + bId);
		
		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);
//		System.out.println("dto.bFile ==" + dto.getbFile());
		
		request.setAttribute("dto", dto);
		
		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);
		

		System.out.println("사사나BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("나나사BContentCommand bPageDataCount == "+bPageDataCount);
		
		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));
		
		request.setAttribute("bSearchDto", bSearchDto);
		
		String page = request.getParameter("page");
		String searchCol = request.getParameter("searchCol");
		String searchVal = request.getParameter("searchVal");
		String pageDataCount = request.getParameter("pageDataCount");
		
		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}
		
		System.out.println("String page = request.getParameter(\"page\"); " +page);
		System.out.println("String searchCol = request.getParameter(\"searchCol\") ;"+searchCol);
		System.out.println("String searchVal = request.getParameter(\"searchVal\") ;"+searchVal);
		System.out.println("String pageDataCount = request.getParameter(\"pageDataCount\") ;"+pageDataCount);
		
		return "redirect:/bContentCommand?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;		
	}
}
