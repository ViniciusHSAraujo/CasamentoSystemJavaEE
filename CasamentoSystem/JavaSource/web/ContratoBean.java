package web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import java.util.List;

import entities.Contrato;
import services.ServiceContrato;
import util.JSFUtils;

@RequestScoped
@Named
public class ContratoBean {

	private Contrato contrato;
		
	@EJB
	private ServiceContrato serviceContrato;
	
	public ContratoBean() {
		this.contrato = new Contrato();
	}
	
	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	public void cadastrarContrato() {
		this.serviceContrato.cadastrarContrato(contrato);
		JSFUtils.enviarMensagemDeTexto("Contrato cadastrado com sucesso!");
		this.contrato = new Contrato();

	}
	
	public void excluirContrato(Contrato contrato) {
		try {
			this.serviceContrato.excluirContrato(contrato);
			JSFUtils.enviarMensagemDeTexto("Contrato excluído com sucesso!");
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());;
		}
	}
	
	public List<Contrato> listarContratos(){
		return this.serviceContrato.listarContratos();
	}
	
}
