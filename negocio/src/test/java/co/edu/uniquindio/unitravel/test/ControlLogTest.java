package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.ControlLog;
import co.edu.uniquindio.unitravel.repositorios.ControlLogRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ControlLogTest {

    @Autowired
    private ControlLogRepo controlLogRepo;

    @Test
    public void ingresarLog()
    {
    ControlLog log = new ControlLog(1,"Alvaro","motita", LocalDate.parse("2022-05-06"),"Login");
        ControlLog logGuardado = controlLogRepo.save(log);

        Assertions.assertNotNull(logGuardado);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarLogs()
    {
        List<ControlLog> listaLogs = controlLogRepo.findAll();
        System.out.println(listaLogs);

    }
}
