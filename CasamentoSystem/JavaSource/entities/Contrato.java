package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.sun.istack.internal.NotNull;

import enumerados.TipoContrato;

/**
 * 
 * Classe que representa o contrato de prestação de serviços para o casamento.
 * 
 * @author Vinícius Araújo
 * @Entity -> Informa ao JSF que é uma ENTIDADE (e cria uma tabela no banco de
 *         dados).
 * 
 */
@Entity
public class Contrato {

	/**
	 * Identificação de cada contrato
	 * 
	 * @SequenceGenerator e @GeneratedValue fazem com que o sistema gere uma
	 *                    numeração sequencial para cada contrato automaticamente.
	 * 
	 */
	@Id
	@SequenceGenerator(name = "CONTADOR_CONTRATOS", sequenceName = "NUM_SEQ_CONTRATO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_CONTRATOS")
	private Integer id;

	/**
	 * Nome dos Noivos
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private String noivos;

	/**
	 * Local onde o evento será realizado.
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private String localDoEvento;

	/**
	 * Local onde a cerimônia será realizada.
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private String localDaCerimonia;

	/**
	 * Data e Hora do evento.
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private Date dataHora;

	/**
	 * Número do telefone de contato do casal.
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private String contato;

	/**
	 * Número de Convidados para o evento.
	 * 
	 * @Min - Restringe o número mínimo de convidados(value: valor para a restrição,
	 *      message: mensagem a ser informada ao usuário caso caia na restrição).
	 * @Max - Restringe o número máximo de convidados(value: valor para a restrição,
	 *      message: mensagem a ser informada ao usuário caso caia na restrição).
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@Min(value = 100, message = "É necessário no mínimo 100 convidados para realizar o contrato.")
	@Max(value = 200, message = "É permitido no máximo 200 convidados por contrato.")
	@NotNull
	private Integer numeroDeConvidados;

	/**
	 * Valor do Contrato
	 * 
	 * @Min - Restringe o valor mínimo para lançamento do contrato(value: valor para
	 *      a restrição, message: mensagem a ser informada ao usuário caso caia na
	 *      restrição).
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@Min(value = 5200, message = "Valor mínimo para o contrato é de R$5200,00.")
	@NotNull
	private Integer valorDoContrato;

	/**
	 * Tipo de contrato: Lançará no banco de dados: 1 - Acessoria 2 - Cerimonialista
	 * 3 - Organização do Evento
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private TipoContrato tipoDeContrato;

	/**
	 * Pagamento true -> se estiver pago. false-> se estiver em aberto.
	 * 
	 * @NotNull - Informa ao banco que o valor não pode ser nulo.
	 */
	@NotNull
	private Boolean pago;

	public Contrato() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoivos() {
		return noivos;
	}

	public void setNoivos(String noivos) {
		this.noivos = noivos;
	}

	public String getLocalDoEvento() {
		return localDoEvento;
	}

	public void setLocalDoEvento(String localDoEvento) {
		this.localDoEvento = localDoEvento;
	}

	public String getLocalDaCerimonia() {
		return localDaCerimonia;
	}

	public void setLocalDaCerimonia(String localDaCerimonia) {
		this.localDaCerimonia = localDaCerimonia;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getNumeroDeConvidados() {
		return numeroDeConvidados;
	}

	public void setNumeroDeConvidados(Integer numeroDeConvidados) {
		this.numeroDeConvidados = numeroDeConvidados;
	}

	public Integer getValorDoContrato() {
		return valorDoContrato;
	}

	public void setValorDoContrato(Integer valorDoContrato) {
		this.valorDoContrato = valorDoContrato;
	}

	public TipoContrato getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(TipoContrato tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	/**
	 * Verifica a situação de pagamento e retorna uma STRING para a listagem:
	 * 
	 * @return "Pago" caso conste como true no banco de dados.
	 * @return "Em Aberto" caso conste como false no banco de dados.
	 */
	public String getSituacaoPagamento() {
		if (pago) {
			return "Pago";
		} else {
			return "Em Aberto";
		}
	}

	/**
	 * Método criado para retornar o "Valor do Contrato" com formatação.
	 * 
	 * @return uma string formatada para sair na listagem como valor monetário.
	 *         Formatação: R$XXXX,00.
	 */
	public String getValorDoContratoComRS() {
		return "R$ " + valorDoContrato.toString() + ",00";
	}
}
