package av2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@Table(name="fornecedor")
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idFornecedor;

	@Column(nullable=false, length=18)
	private String cnpj;

	@Column(nullable=false, length=100)
	private String razaoSocial;

	@Column(nullable=false, precision=65, scale=2)
	private BigDecimal receitaBruta;
	
	@Column(length=12)
	private String inscricaoMunicipal;

	@OneToOne
	@JoinColumn(name="Endereco_idEndereco", nullable=false)
	private Endereco endereco;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="fornecedor")
	private Set<Processo> processos;

	public Fornecedor() {
	}

	public int getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public BigDecimal getReceitaBruta() {
		return this.receitaBruta;
	}

	public void setReceitaBruta(BigDecimal receitaBruta) {
		this.receitaBruta = receitaBruta;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Processo> getProcessos() {
		return this.processos;
	}

	public void setProcessos(Set<Processo> processos) {
		this.processos = processos;
	}

	public Processo addProcesso(Processo processo) {
		getProcessos().add(processo);
		processo.setFornecedor(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setFornecedor(null);

		return processo;
	}

}