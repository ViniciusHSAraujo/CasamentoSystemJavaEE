package enumerados;

/**
 * Classe de enumerados para os tipos de contratos disponíveis.
 * @author Vinícius Araújo
 *
 */
public enum TipoContrato {

	/**
	 * Para adicionar um novo tipo de contrato, basta colocar abaixo:
	 */
	ACESSORIA("Acessoria"), CERIMONIALISTA("Cerimonialista"), ORGANIZACAO_DO_EVENTO("Organização do Evento");

	private TipoContrato() {

	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private TipoContrato(String descricao) {
		this.descricao = descricao;
	}

}
