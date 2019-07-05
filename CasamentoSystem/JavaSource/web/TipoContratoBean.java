package web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import enumerados.TipoContrato;

@Named
@ApplicationScoped
public class TipoContratoBean {
	
	public TipoContrato[] listaTiposDeContrato() {
		return TipoContrato.values();
	}
}
