package com.formations.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formations.model.Formation;
import com.formations.service.IFormationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("formationAction")
public class FormationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IFormationService formationService;

	private List<Formation> listFomartions;

	private Formation formation;

	@Override
	public String execute() throws Exception {
		formation = new Formation();
		listFomartions = formationService.getAllFormations();
		return super.execute();
	}

	public String supprimerFormation() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		formationService.deleteFormation(Long.parseLong(request.getParameter("id")));
		return execute();
	}

	public String enregistrerFormation() throws Exception {
		formationService.saveFormation(formation);
		return execute();
	}

	public String modifierFormation() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		formation = formationService.getFormationById(Long.parseLong(request.getParameter("id")));
		listFomartions = formationService.getAllFormations();
		return SUCCESS;
	}

	public List<Formation> getListFomartions() {
		return listFomartions;
	}

	public void setListFomartions(List<Formation> listFomartions) {
		this.listFomartions = listFomartions;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
