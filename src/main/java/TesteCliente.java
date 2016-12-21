import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ifidelize.model.EnumTipoPessoa;
import com.ifidelize.model.TbCidade;
import com.ifidelize.model.TbCliente;

public class TesteCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("iFidelizePU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		TbCidade cidade = new TbCidade();
		cidade.setDes_nome("Guararapes");
		cidade.setDes_uf("SP");
		cidade.setNum_estado(1);
		manager.persist(cidade);
		
		TbCliente cliente = new TbCliente();
		cliente.setDes_nome("Rogério Xonchim Alves Correa 2");
		cliente.setDes_cpf("355.008.108-12");
		cliente.setDes_rg("40.323.578-9");
		cliente.setDes_endereco("Francisco Lemos da Silva");
		cliente.setDes_numero("73");
		cliente.setDes_bairro("Cohab 3");
		cliente.setDes_cep("16700-000");
		cliente.setDes_email("rogerio.alves@intersotis.com.br");
		cliente.setDes_telefone("(18) 99643-0403");
		cliente.setDes_senha("123456");
		cliente.setBol_situacao(true);
		cliente.setDta_cadastro(new Date());
		cliente.setTipo(EnumTipoPessoa.FISICA);
		cliente.setCod_cidade(cidade);
		
		manager.persist(cliente);
		
		trx.commit();
	}
	
}
