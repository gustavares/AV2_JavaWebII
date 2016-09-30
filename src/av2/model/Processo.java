package av2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the processo database table.
 * 
 */
@Entity
@Table(name="processo")
@NamedQuery(name="Processo.findAll", query="SELECT p FROM Processo p")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idProcesso;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataRelatorio;

	@Column(nullable=false, length=100)
	private String fiscalResponsavel;

	@Column(nullable=false, length=500)
	private String relatoFiscalizacao;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="Fornecedor_idFornecedor", nullable=false)
	private Fornecedor fornecedor;

	public Processo() {
	}

	public int getIdProcesso() {
		return this.idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Date getDataRelatorio() {
		return this.dataRelatorio;
	}

	public void setDataRelatorio(Date dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}

	public String getFiscalResponsavel() {
		return this.fiscalResponsavel;
	}

	public void setFiscalResponsavel(String fiscalResponsavel) {
		this.fiscalResponsavel = fiscalResponsavel;
	}

	public String getRelatoFiscalizacao() {
		return this.relatoFiscalizacao;
	}

	public void setRelatoFiscalizacao(String relatoFiscalizacao) {
		this.relatoFiscalizacao = relatoFiscalizacao;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}