package es.open4job.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoMotoDAO;
import es.open4job.web.form.AparcamientoMotosForm;

public class LstMotosAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AparcamientoMotoDAO aparcamientoMotoDao = new AparcamientoMotoDAO();
		List<AparcamientoMotosForm> motos =  aparcamientoMotoDao.getLstAparcamientoMoto();
		request.setAttribute("lstMotos", motos);
		return mapping.findForward("success");
	}

}
