package examples.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import examples.component.repository.OrganizationDAO;
import examples.entity.OrganizationModel;

@Controller
public class OrganizationServiceController {
	@Autowired
	private OrganizationDAO organizationDAO;

	public OrganizationServiceController() {
		super();
	}

	@RequestMapping(value="/organization/{organizationId}.do", method=RequestMethod.GET)
	public ModelAndView showOrganization(@PathVariable("organizationId") String id){
		OrganizationModel organizationModel = this.organizationDAO.getOrganization(id);
		String name = "organization/view";
		return new ModelAndView(name, "organization", organizationModel);
	}

	@RequestMapping(value="/organization/list.do", method=RequestMethod.GET)
	public ModelAndView showOrganizations(){
		List<OrganizationModel> list = this.organizationDAO.findAll();

		String name = "organization/list";
		return new ModelAndView(name, "organizations", list);
	}


	@RequestMapping(value="/organization/entry.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String executeEntry(){
		try{
			OrganizationModel organizationModel = new OrganizationModel();
			organizationModel.setId("staff");
			organizationModel.setName("総務部");

			this.organizationDAO.entryOrganization(organizationModel);
			return "success !";
		}
		catch(Exception e){
			e.printStackTrace();
			return "failure !";
		}
	}

}
