package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list", 
			method=RequestMethod.GET)
	public String boaldListGet(Model model) {
		ArrayList list = null;
		list = (ArrayList)boardService.getBoardLists();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/board/register",
			method=RequestMethod.GET)
	public String boardRegisterGet() {
		return "board/register";
	}
	@RequestMapping(value="/board/register",
			method=RequestMethod.POST)
	public String boardRegisterPost(BoardVo boardVo) {
		boardVo.setAuthor("관리자");
		boardService.registerBoard(boardVo);
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/detail",
			method=RequestMethod.GET)
	public String boardDetailGet(int num, Model model) {
		BoardVo boardVo = boardService.getBoard(num);
		model.addAttribute("board", boardVo);
		return "board/detail";
	}
	@RequestMapping(value="/board/delete",
			method=RequestMethod.GET)
	public String boardDeleteGet(int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/modify",
			method=RequestMethod.GET)
	public String boardModifyGet(Integer num, Model model) {
		//정상 경로로 수정페이지에 접근한게 아니면
		if(num == null) {
			return "redirect:/board/list";
		}
		BoardVo boardVo = boardService.getBoard(num);
		model.addAttribute("board",boardVo);
		return "board/modify";
	}
	@RequestMapping(value="/board/modify",
			method=RequestMethod.POST)
	public String boardModifyPost(BoardVo boardVo) {
		boardService.updateBoard(boardVo);
		return "redirect:/board/list";
	}
}






