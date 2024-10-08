package api;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

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
    @Description("Valida a resposta do Post de um order")
    public void validaRespostaPostOrder() throws IOException {
        Response response = validacoesStore.fazerPostOrder();
        validacoesStore.validarPostOrder(response);
    }

    @Test
    @Description("Valida a pesquisa de pets com status Pending")
    public void validarPetPending() throws IOException {
        validacoesPet.fazerPostPet(); // Notei que a API sempre fica apagando os dados inseridos ou mudando os dados requeridos.
        validacoesPet.validarGetPetPending();
    }

    @Test
    @Description("Valida a resposta do Put de um pet")
    public void validarPutPet() throws IOException {
        Response response = validacoesPet.fazerPutPet();
        validacoesPet.validarPutPet(response);
    }
}