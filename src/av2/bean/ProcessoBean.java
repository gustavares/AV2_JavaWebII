package av2.bean;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import av2.dao.DAO;
import av2.model.Processo;

@ManagedBean
@SessionScoped
public class ProcessoBean {

	private Processo processo;
	
	public Processo getProcesso() {
		
		if(processo == null)
			return new Processo();
		
		return processo;
	}
	
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	public List<Processo> getProcessos(){
		return new DAO<Processo>(Processo.class).listar();
	}
	
	public String editarProcesso(Processo processo){
		if(processo == null)
			this.processo = new Processo();
		else
			this.processo = processo;
		
		return "cadastro-processo.xhtml?faces-redirect=true";
	}
}
