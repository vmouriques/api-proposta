package br.com.proposta.api.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.proposta.api.dto.SolicitacaoDto;
import br.com.proposta.api.dto.SolicitacaoRepostaDto;
import br.com.proposta.api.entities.Solicitacao;
import br.com.proposta.api.entities.Veiculo;
import br.com.proposta.api.services.PropostaService;
import br.com.proposta.api.services.SolicitacaoService;
import br.com.proposta.api.services.VeiculoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SolicitacaoController.class)
class SolicitacaoControllerTest {

	@MockBean
	private SolicitacaoService solicitacaoService;

	@MockBean
	private VeiculoService veiculoService;

	@MockBean
	private PropostaService propostaService;

	@Autowired
	private MockMvc mockMvc;

	private JacksonTester<SolicitacaoDto> jsonInput;
	private JacksonTester<SolicitacaoRepostaDto> jsonOutput;

	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	void registraNovaSolicitacaoTest() throws Exception {
		String nome = "rafael";
		String email = "rafael@email.com";
		String cpf = "00000000-00";
		String modelo = "fusca";
		Integer ano = 1973;
		BigDecimal valor = BigDecimal.valueOf(8000);

		Veiculo veiculo = new Veiculo("fusca", 1973, BigDecimal.valueOf(8000));
		Solicitacao solicitacao = new Solicitacao(nome, email, cpf, veiculo, null);
		SolicitacaoDto solicitacaoDto = new SolicitacaoDto(nome, email, cpf, modelo, ano, valor);

		given(veiculoService.save(any(Veiculo.class))).willReturn(veiculo);
		given(solicitacaoService.save(any(Solicitacao.class))).willReturn(solicitacao);

		MockHttpServletResponse response = mockMvc.perform(post("/financiamento/v1/solicitacoes")
				.contentType(MediaType.APPLICATION_JSON).content(jsonInput.write(solicitacaoDto).getJson())).andReturn()
				.getResponse();

		verify(veiculoService).save(veiculo);
		verify(solicitacaoService).save(solicitacao);
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString())
				.isEqualTo(jsonOutput.write(new SolicitacaoRepostaDto(solicitacao)).getJson());
	}

}
