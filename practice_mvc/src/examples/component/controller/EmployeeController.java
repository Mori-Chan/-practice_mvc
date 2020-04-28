package examples.component.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import examples.component.repository.EmployeeDAO;
import examples.entity.EmployeeModel;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeController() {
		super();
	}


	@RequestMapping(value = "/employee/first.do", method = RequestMethod.GET)
	public ModelAndView showEmployees1(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		model.addAttribute("checkSort", getCheckSort());
		model.addAttribute("checkCend", getCheckCend());

		empm.setCend("asc");
		empm.setSort("ID");

		List<EmployeeModel> list = this.employeeDAO.findAll(empm);
		String name = "employee/list";

		return new ModelAndView(name, "employees", list);
	}

	@RequestMapping(value = "/employee/sort.do", method = RequestMethod.GET)
	public ModelAndView showEmployees(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm ){


	    model.addAttribute("checkSort", getCheckSort());
	    model.addAttribute("checkCend", getCheckCend());


		List<EmployeeModel> list = this.employeeDAO.findAll(empm);

		String name = "employee/list";

		return new ModelAndView(name, "employees", list);
	}

	private List<String> getCheckSort() {
	    List<String> list = new LinkedList<>();
	    list.add("ID");
	    list.add("姓");
	    list.add("名");
	    list.add("性別");
	    list.add("生年月日");
	    return list;
	}

	private List<String> getCheckCend() {
	    List<String> list = new LinkedList<>();
	    list.add("ASC");
	    list.add("DESC");
	    return list;
	}


	@RequestMapping(value = "/employee/move.do", method = RequestMethod.GET)
	public String move(Model model) {
		return "employee/entry";
	}


	@RequestMapping(value = "/employee/detail.do", method = RequestMethod.GET)
	public ModelAndView showEmployee(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		EmployeeModel employeeModel = this.employeeDAO.findDetail(empm);

		String name = "employee/detail";
		return new ModelAndView(name, "employee", employeeModel);
	}

	@RequestMapping(value="/employee/conform.do", method=RequestMethod.POST)
	public ModelAndView Conform(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		EmployeeModel employeeModel = this.employeeDAO.findDetail(empm);

		if(empm.getId().equals("") || empm.getFamily_name().equals("") || empm.getFirst_name().equals("") || empm.getSex().equals("") || empm.getBirthday().equals("")){
			empm.setMsg("新規登録できませんでした。\r\n入力内容が間違っています。");
			String name = "employee/entry";
			return new ModelAndView(name, "employee", empm);
		}

		if(employeeModel != null) {
			empm.setMsg("このIDは使用できません。");
			String name = "employee/entry";
			return new ModelAndView(name, "employee", empm);
		}else {
//		model.addAttribute("id", empm.getSort());
//		model.addAttribute("family_name", empm.getCend());
//		model.addAttribute("first_name", empm.getSort());
//		model.addAttribute("sex", empm.getCend());
//		model.addAttribute("birthday", empm.getCend());


		String name = "employee/conform";


//		return new ModelAndView(name, "employee", model);
		return new ModelAndView(name, "employee", empm);
		}

	}


	@RequestMapping(value="/employee/entry.do", method=RequestMethod.POST)
	public ModelAndView executeEntry(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		try{
			this.employeeDAO.entryEmployee(empm);

			EmployeeModel employeeModel = this.employeeDAO.findDetail(empm);

			String name = "employee/detail";
			return new ModelAndView(name, "employee", employeeModel);
		}catch(Exception e) {
			empm.setMsg("新規登録できませんでした。\r\n入力内容が間違っています。");
			String name = "employee/entry";
			return new ModelAndView(name, "employee", empm);
		}

	}

	@RequestMapping(value="/employee/update.do", method=RequestMethod.POST)
	public ModelAndView executeUpdate(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		try{
			if(empm.getId().equals("") || empm.getFamily_name().equals("") || empm.getFirst_name().equals("") || empm.getSex().equals("") || empm.getBirthday().equals("")){
				empm.setMsg("更新できませんでした。\r\n入力内容が間違っています。");
				String name = "employee/detail";
				return new ModelAndView(name, "employee", empm);
			}
			this.employeeDAO.updateEmployee(empm);

			EmployeeModel employeeModel = this.employeeDAO.findDetail(empm);

			String name = "employee/detail";
			return new ModelAndView(name, "employee", employeeModel);
		}catch(Exception e) {
			empm.setMsg("更新できませんでした。");
			String name = "employee/detail";
			return new ModelAndView(name, "employee", empm);
		}

	}

	@RequestMapping(value="/employee/delete.do", method=RequestMethod.POST)
	public ModelAndView executeDelete(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){

		try{
			this.employeeDAO.deleteEmployee(empm);

			model.addAttribute("checkSort", getCheckSort());
			model.addAttribute("checkCend", getCheckCend());

			empm.setCend("asc");
			empm.setSort("ID");

			System.out.println(empm.getCend() + empm.getSort());

			List<EmployeeModel> list = this.employeeDAO.findAll(empm);
			String name = "employee/list";

			return new ModelAndView(name, "employees", list);
		}catch(Exception e) {
			EmployeeModel employeeModel = this.employeeDAO.findDetail(empm);

			employeeModel.setMsg("削除できませんでした。");
			String name = "employee/detail";
			return new ModelAndView(name, "employee", employeeModel);
		}

	}
	@RequestMapping(value="/employee/cancel.do", method=RequestMethod.POST)
	public ModelAndView cancel(Model model, @ModelAttribute("EmployeeModel") EmployeeModel empm){
		empm.setMsg("");
		String name = "employee/entry";
		return new ModelAndView(name, "employee", empm);
	}



//	@RequestMapping(value = "/employee/list.do", method = RequestMethod.GET)
//	public ModelAndView showEmployees(@ModelAttribute("employeeModel") EmployeeModel empm, Model model){
//
//	    model.addAttribute("checkSort", getCheckSort());
//	    model.addAttribute("checkCend", getCheckCend());
//
//		List<EmployeeModel> list = this.employeeDAO.findAll(empm);
//
//		String name = "employee/list";
//		EmployeeModel employeesModel = new EmployeeModel();
//		System.out.println(employeesModel.getSort() + employeesModel.getCend());
//		return new ModelAndView(name, "employees", list);
//	}

//	@RequestMapping(value="/employee/detail.do", method=RequestMethod.GET)
//	public ModelAndView showEmployee(@PathVariable("employeeId") String id){
//		EmployeeModel employeeModel = this.employeeDAO.getEmployee(id);
//		String name = "employee/view";
//		return new ModelAndView(name, "employees", employeeModel);
//	}

//	@RequestMapping(value="/employee/entry.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
//	@ResponseBody
//	public String executeEntry(){
//		try{
//			EmployeeModel employeeModel = new EmployeeModel();
//			employeeModel.setId("staff");
//			employeeModel.setName("総務部");
//
//			this.employeeDAO.entryEmployee(employeeModel);
//			return "success !";
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			return "failure !";
//		}
//	}

}



// http://localhost:8080/practice_mvc/employee/first.do