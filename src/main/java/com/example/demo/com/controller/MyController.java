package com.example.demo.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.FreeIns;
import com.example.demo.com.pojo.MenuUtil;
import com.example.demo.com.pojo.PageBean;
import com.example.demo.com.pojo.RoleMenu;
import com.example.demo.com.pojo.Text1;
import com.example.demo.com.pojo.TreeBean;
import com.example.demo.com.service.FreeInsMapperService;
import com.example.demo.com.service.MenuUtilService;
import com.example.demo.com.service.RoleService;
import com.example.demo.com.service.UserService;

@Controller
@RequestMapping("MyController")
public class MyController {

	@Resource
	private MenuUtilService menuUtilService;
	@Resource
	private UserService userService;
	@Resource
	private FreeInsMapperService freeInsMapperService;
	@Resource
	private RoleService roleService;
	//保险确认页面的打回操作 打回给保险人员
	@RequestMapping(value="/updateStuta")
	@ResponseBody
	public String updateStuta (int id) {
		boolean b = freeInsMapperService.updateStuta(id);
		String json=JSONObject.toJSONString(b);
		System.out.println(json);
		return json;
	}
	//查询所有免险用户状态为3的数据 并分页
	@RequestMapping(value="/selectStatus")
	@ResponseBody
	public String selectStatus(HttpSession session, HttpServletRequest request, FreeIns freeIns,
			HttpServletResponse response) {
		int total = freeInsMapperService.selectStatusCount();
		int rows = 10;
  		int page = Integer.parseInt(request.getParameter("page"));
  		int start = (page - 1) * rows;
  		int size = rows;
  		List<FreeIns> list = freeInsMapperService.selectStatus(start, size);
  		PageBean pageBean = new PageBean();
		   pageBean.setRows(list);
		   pageBean.setTotal(total);
		   String json = JSONObject.toJSONString(pageBean);
			System.out.println("-----*****" + json);
			return json;
	}
	//经理确认免险用户
	@RequestMapping(value="/updateStatus")
	@ResponseBody
	public String updateStatus(int id) {
		 int total = freeInsMapperService.selectStatusCount();
		//返回要改变状态的用户
	
		boolean b = freeInsMapperService.updateStatus(id);
		String json = JSONObject.toJSONString(b);
		System.out.println(json);
		return json;
	}
	
	//经理打回用户
	@RequestMapping(value="/updateaFreeIns")
	@ResponseBody
	public String updateaFreeIns(int id) {
		System.out.println("/*-*/*-*/"+id);
		boolean b = freeInsMapperService.updata(id);
	   String json=JSONObject.toJSONString(b);
	   System.out.println(json);
	   return json;
	}
	// 经理对已经提交的免险用户操作
	@RequestMapping(value = "/selectFreeIns")
	@ResponseBody
	public String selectFreeIns(HttpSession session, HttpServletRequest request, FreeIns freeIns,
			HttpServletResponse response) {
		    //先查询免险员工已经提交的免险用户
	     
	        int total=freeInsMapperService.selectCount();
	        
      	
      	    // 获取当前页 page
      		//每页显示十条数据
      		int rows = 10;
      		int page = Integer.parseInt(request.getParameter("page"));
      		int start = (page - 1) * rows;
			// 要显示的条数
			int size = rows;
			   List<FreeIns> list=	freeInsMapperService.selectFreeIns(start,size);
			   PageBean pageBean = new PageBean();
			   pageBean.setRows(list);
			   pageBean.setTotal(total);
			   String json = JSONObject.toJSONString(pageBean);
				System.out.println("-----*****" + json);
				return json;
	}
	// 提交
	@RequestMapping(value = "/upFreeIns")
	@ResponseBody
	public String upFreeIns(int id) {
		System.out.println("------upFreeIns" + id);
		boolean b = freeInsMapperService.upFreeIns(id);
		String json = JSONObject.toJSONString(b);
		return json;
	}

	@RequestMapping(value = "/select")
	public String se(FreeIns freeIns, Model mod) {
		List<FreeIns> freeInsList = freeInsMapperService.selectListFreeIns(freeIns);
		PageBean pb = new PageBean();
		int total = freeInsList.size();
		pb.setRows(freeInsList);
		pb.setTotal(total);
		String json = JSONObject.toJSONString(pb);
		System.out.println(json);
		System.out.println("1111111111111111");

		return "/freeIns/freeIns";

	}

	// 修改FreeIns用户的信息from表单
	@RequestMapping(value = "/updatafreeIns")
	public String updatafreeIns(FreeIns freeIns) {
		boolean b = freeInsMapperService.updateFreeIns(freeIns);
		String s = null;
		if (b == true) {
			s = "freeIns/freeIns";
		} else {
			s = "freeIns/updata";
		}
		return s;
	}

	// 修改FreeIns用户的信息
	@RequestMapping(value = "/updataFreeIns")
	@ResponseBody
	public String updataFreeIns(int id, HttpServletRequest request) {
		System.out.println("**--*--*--***-" + id);

		boolean a = true;
		FreeIns freeIns = freeInsMapperService.selectOneFreeIns(id);
		System.out.println(freeIns);
		HttpSession session = request.getSession();
		// 转换格式
		/*
		 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); String
		 * inPutDate=df.format(freeIns.getInputDate());
		 * System.out.println("--*-/-**-"+inPutDate);
		 */
		session.setAttribute("id", freeIns.getId());
		session.setAttribute("customName", freeIns.getCustomName());
		session.setAttribute("customSex", freeIns.getCustomSex());
		session.setAttribute("customAge", freeIns.getCustomAge());
		session.setAttribute("addr", freeIns.getAddr());
		session.setAttribute("phone", freeIns.getPhone());
		session.setAttribute("status", freeIns.getStatus());
		session.setAttribute("userId", freeIns.getUserId());
		session.setAttribute("inputDate", freeIns.getInputDate());
		String json = JSONObject.toJSONString(a);

		return json;

	}

	// 删除选中的FreeIns用户
	@RequestMapping(value = "/deleteFreeIns")

	public String deleteFreeIns(int id, HttpServletResponse response) {
		System.out.println("/*/*/*/*/*/*/*/*" + id);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = freeInsMapperService.deleteFreeIns(id);
		String json = JSONObject.toJSONString(b);
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
		return "freeIns/freeIns";
	}

	// 添加FreeIns用户
	@RequestMapping(value = "/addFreeIns")
	@ResponseBody
	public String addFreeIns(FreeIns freeIns,HttpSession session) {
		System.out.println("----------addFreeIns");
		int userId = (int) session.getAttribute("userId");
		freeIns.setUserId(userId);
		
		boolean b = freeInsMapperService.addFreeIns(freeIns);
		System.out.println("//////////" + b);
		String json = JSONObject.toJSONString(b);
		return json;
	}

	// 查询freeIns表中所有的数据并传到前台去
	@RequestMapping(value = "/selectAll")
	@ResponseBody
	public String selectAll(HttpSession session, HttpServletRequest request, FreeIns freeIns,
			HttpServletResponse response) {
		System.out.println("-"+freeIns);
		System.out.println(freeIns == null);
		PageBean pageBean = new PageBean();
		int total;
		List<FreeIns> freeInsList = null;
		if (freeIns.getId()==null) {
			// 查询总页数
			System.out.println("---------------------------------------------------");
			int userID = (int) session.getAttribute("userId");
			System.out.println("selectAll   :" + userID);
			total = freeInsMapperService.select();
			System.out.println("*-*-*-*-888881------"+total);
			// 获取当前页 page
			int rows = 10;
			int page = Integer.parseInt(request.getParameter("page"));
			System.out.println("*-*-*-*--*-*-*--page:" + page);
			// 每页要显示的数目

			System.out.println(page + "-*-*--*-*-*--*-*-*-" + rows);
			// 开始 start
			int start = (page - 1) * rows;
			// 要显示的条数
			int size = rows;
			System.out.println("*****************" + start + "--------" + size);
			freeInsList = freeInsMapperService.selectFreeInsMapper(start, size, userID);
		} else {
			  freeInsList= freeInsMapperService.selectListFreeIns(freeIns);
			  total=freeInsList.size();
				System.out.println("*-*-*-*-888882------"+total);
		}
		pageBean.setRows(freeInsList);
		System.out.println("---" + freeInsList);
		System.out.println("*-*-*-*-888883------"+total);
		pageBean.setTotal(total);
		String json = JSONObject.toJSONString(pageBean);
		System.out.println("-----*****" + json);
		return json;
	}

	// 异步修改密码
	@RequestMapping(value = "/updata")
	@ResponseBody
	public String updateUser(String userName, String pwd, String pwdj) {
		System.out.println("------" + userName + "-------" + pwd + "------" + pwdj);
		int i = userService.updataUser(userName, pwd, pwdj);
		boolean b = false;
		if (i > 0) {
			b = true;
		}
		String json = JSONObject.toJSONString(b);
		System.out.println("updata" + json);
		return json;
	}

	// 异步查询用户名是否存在
	@RequestMapping(value = "/userPwd")
	@ResponseBody
	public String selectUser(String userName) {
		System.out.println("aaa" + userName);
		boolean b = userService.selectUser(userName);

		/*
		 * List<User> userList= new ArrayList<User>(); userList =
		 * userService.selectUserAll();
		 */
		String json = JSONObject.toJSONString(b);
		System.out.println("-------1" + json);
		return json;
	}

	/**
	 * 加载树结构
	 * 
	 * @return
	 */
	@RequestMapping(value = "/men")
	@ResponseBody
	public String men(HttpServletRequest request, int idd) {

		List<MenuUtil> menuUtilList = new ArrayList<MenuUtil>();
		List<RoleMenu> roleMenuList = null;
		List<TreeBean> treeBeanList = null;
		// idd是否为零是为了区别 是分配权限请求还是 登陆加载请求 0代表登陆加载请求
		if (idd == 0) {
			System.out.println("----------------------------");
			HttpSession session = request.getSession();
			int level = (int) session.getAttribute("rid");
			System.out.println("~```````````````~````" + level);
			if (level != 4) {
				System.out.println("////////////////////////////////");
				System.out.println("level:"+level);
				roleMenuList = roleService.selectIdd(level);
				// 查出对应idd的树结构
				System.out.println("........men" + roleMenuList);

				for (RoleMenu roleMenu : roleMenuList) {
					MenuUtil menuUtil = new MenuUtil();

					menuUtil = menuUtilService.select(roleMenu.getMenuNum());
					menuUtilList.add(menuUtil);
				}

			} else {
				menuUtilList = menuUtilService.selectAll();
				System.out.println("----" + menuUtilList);

			}
			System.out.println("``````````````````````````" + menuUtilList);
			treeBeanList = new ArrayList<TreeBean>();
			for (MenuUtil menuUtil : menuUtilList) {
				String id = menuUtil.getMenuNum();// 菜单编号
				System.out.println("id:"+id);
				String pid = menuUtil.getPmenuNum();
				System.out.println("pid"+pid);
				// 父id
				String text = menuUtil.getMenuText(); // 标签内容
				System.out.println("text"+text);
				String url = menuUtil.getMenuUrl(); //// 菜单对应的路径url //fuid id text url TreeBean
				System.out.println("url"+url);
				TreeBean treeBean = new TreeBean(pid, id, text, url);
				System.out.println("treeBean"+treeBean);
				treeBeanList.add(treeBean);
				System.out.println("treeBeanList"+treeBeanList);
				System.out.println("---------------------8");
			}
			// 权限管理
		} else {
			menuUtilList = menuUtilService.selectAll();
			treeBeanList = new ArrayList<TreeBean>();

			for (MenuUtil menuUtil : menuUtilList) {

				String id = menuUtil.getMenuNum();// 菜单编号
				String pid = menuUtil.getPmenuNum();
				// 父id
				String text = menuUtil.getMenuText(); // 标签内容
				String url = menuUtil.getMenuUrl(); //// 菜单对应的路径url //fuid id text url TreeBean
				TreeBean treeBean = new TreeBean(pid, id, text, url);
				treeBeanList.add(treeBean);
			}
			// 权限请求 打对勾 查找本次角色对应的树结构是否为空
			// 不是的话就直接上传全部树结构 是的话就要
			// private boolean checked=false;//菜单是否被选中 遍历判断变 true
			boolean b = roleService.select(idd);
			System.out.println("@@@@@@@@@" + b);
			if (b) {
				// 有
				// 是的话就要
				// private boolean checked=false;//菜单是否被选中 遍历判断变 true
				// 查出对应的树结构
				System.out.println("----------idd----" + idd);
				roleMenuList = roleService.selectIdd(idd);
				System.out.println("***********" + roleMenuList);
				System.out.println("------------+" + treeBeanList);
				for (TreeBean treeBean : treeBeanList) {
					for (RoleMenu roleMenu : roleMenuList) {
						if (treeBean.getPid() != null) {
							if (treeBean.getId().equals(roleMenu.getMenuNum())) {
								treeBean.setChecked(true);
							}
						}
					}

				}

			}
		}
		System.out.println("---------------------------------------------99");
		System.out.println("#############" + treeBeanList);

		String json = JSONObject.toJSONString(treeBeanList);
		System.out.println(json);
		return json;
	}
	@RequestMapping(value="/aaa")
	@ResponseBody
	public String aaa(HttpSession session) {
		
		int i = (int) session.getAttribute("userId");
		int b =freeInsMapperService.selectAAA(i);
		int c =freeInsMapperService.selectBBB(i);
		Text1 t=new Text1();
		t.setSum(b);
		t.setDaysum(c);
	PageBean pb = new PageBean();
	List<Text1> list = new ArrayList<Text1>();
	list.add(t);
	pb.setRows(list);
	pb.setTotal(2);
	
		System.out.println(t);
		String json = JSONObject.toJSONString(pb);
		System.out.println(json);
		return json;
	}

}
