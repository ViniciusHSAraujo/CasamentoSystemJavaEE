package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Contrato;

/**
 * Classe de serviço para o contrato:
 * @author Vinícius Henrique Santos Araújo
 *
 */
@Stateless
public class ServiceContrato {

	/**
	 * Gerenciador de Entidades que faz as conexões com o banco de dados.
	 */
	@PersistenceContext
	private EntityManager em;

	public void cadastrarContrato(Contrato contrato) {
		this.em.persist(contrato);
	}

	/**
	 * Método utilizado para listar os contratos do banco de dados.
	 * @return
	 */
	public List<Contrato> listarContratos() {
		return this.em.createQuery("SELECT c FROM Contrato c", Contrato.class).getResultList();
	}

	/**
	 * Método utilizado para excluir os contratos existentes no banco de dados.
	 * @param contrato - Contrato a se excluir do banco de dados
	 * @throws Exception - Caso o contrato já esteja pago, não deve-se permitir a exclusão do mesmo.
	 */
	public void excluirContrato(Contrato contrato) throws Exception {
		if (contrato.getPago()) {
			throw new Exception("Não é possível excluir contratos já pagos.");
		} else {
			this.em.remove(this.em.merge(contrato));
		}
	}
}
