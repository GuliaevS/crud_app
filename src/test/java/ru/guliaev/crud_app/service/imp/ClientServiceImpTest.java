package ru.guliaev.crud_app.service.imp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.guliaev.crud_app.entity.Client;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImpTest {

    private ClientServiceImp clientService = new ClientServiceImp(null);

    @Test
    public void calculate_multiplyCommand_success() {
        BigDecimal result = clientService.calculate(new BigDecimal(10), new BigDecimal(5), "multiply");

        Assertions.assertEquals(new BigDecimal(50), result);
    }

    @Test
    public void calculate_addCommand_success() {
        BigDecimal result = clientService.calculate(new BigDecimal(10), new BigDecimal(5), "add");

        Assertions.assertEquals(new BigDecimal(15), result);
    }

    @Test
    public void calculate_maxCommand_success() {
        BigDecimal result = clientService.calculate(new BigDecimal(10), new BigDecimal(5), "max");

        Assertions.assertEquals(new BigDecimal(10), result);
    }

    @Test
    public void calculate_invalidCommand_exception() {
        Assertions.assertThrowsExactly(RuntimeException.class,
                () -> clientService.calculate(new BigDecimal(10), new BigDecimal(5), "v1"));
    }

    @Test
    void createNewClient_correctParams_success() {
        Client result = clientService.createNewClient("Andrew", "Bessonov");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Andrew", result.getName());
        Assertions.assertEquals("Bessonov", result.getSurname());
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    void calculate_divideCommand_success(){
        BigDecimal result = clientService.calculate(new BigDecimal(25),new BigDecimal(5),"divide");
        Assertions.assertEquals(new BigDecimal(5),result);
    }
}
