package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SessaoTest {

	private Sessao sessao;
	
	@Before
	public void setUp(){
		sessao = new Sessao();
	}
	
	@Test
	public void deveVender2IngressosSeHa2Vagas(){
		
		sessao.setTotalIngressos(2);
		
		assertThat(sessao.podeReservar(2), is(equalTo(true)));
	}

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {

        sessao.setTotalIngressos(2);

        assertThat(sessao.podeReservar(1), is(equalTo(true)));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {

		sessao.setTotalIngressos(2);

		assertThat(sessao.podeReservar(3), is(equalTo(false)));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {

		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		assertThat(2, is(equalTo(sessao.getIngressosDisponiveis().intValue())));
	}
}
