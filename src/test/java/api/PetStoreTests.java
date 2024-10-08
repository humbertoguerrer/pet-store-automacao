package api;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PetStoreTests {

    private final ValidacoesPet validacoesPet = new ValidacoesPet();
    private final ValidacoesStore validacoesStore = new ValidacoesStore();

    @BeforeAll
    public static void configuracao() {
        BaseApi.configurar();
    }

    @Test
    @Description("Valida a resposta da pesquisa por um pet inexistente")
    public void validarPesquisaPorPetInexistente() {
        validacoesPet.validarPesquisaPorPetInexistente(9999999);
    }

    @Test
    @Description("Valida a resposta do Post de um pedido")
    public void validaRespostaPostOrder() throws IOException {

        Response response = validacoesStore.fazerPost();
        validacoesStore.validarPostOrder(response);

    }
}